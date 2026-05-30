package com.woosung.quick.delivery.service.order.impl;

import com.woosung.quick.delivery.common.Supports.ErrorCode;
import com.woosung.quick.delivery.common.exception.InvalidTotalPointsException;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CancelOrderCommand;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderCommand;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderStoreCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.UsePointCommand;
import com.woosung.quick.delivery.common.model.info.OrderInfo;
import com.woosung.quick.delivery.common.model.info.StoreInfo;
import com.woosung.quick.delivery.common.model.query.OrderQuery.GetOrderTotalPointsQuery;
import com.woosung.quick.delivery.common.model.query.OrderQuery.SelectOrderQuery;
import com.woosung.quick.delivery.common.model.query.OrderQuery.SelectOrdersQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.*;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CancelOrderResult;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.UsePointResult;
import com.woosung.quick.delivery.payload.response.OrderResponse.GetOrderResponse;
import com.woosung.quick.delivery.payload.response.OrderResponse.GetOrdersResponse;
import com.woosung.quick.delivery.payload.response.OrderResponse.ValidateTotalPointResponse;
import com.woosung.quick.delivery.repository.order.OrderRepository;
import com.woosung.quick.delivery.service.order.OrderService;
import com.woosung.quick.delivery.service.order.OrderStoreService;
import com.woosung.quick.delivery.service.order.verifier.OrderAmountVerifier;
import com.woosung.quick.delivery.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.woosung.quick.delivery.payload.response.OrderResponse.CancelOrderResponse;
import static com.woosung.quick.delivery.payload.response.OrderResponse.CreateOrderResponse;
import static com.woosung.quick.delivery.payload.request.OrderRequest.*;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
    private final OrderStoreService orderStoreService;
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final OrderAmountVerifier orderAmountVerifier;


    @Override
    public GetOrdersResponse getOrders(String customerId) {
        SelectOrdersQuery selectOrdersQuery = SelectOrdersQuery.builder()
                .customerId(customerId)
                .build();
        SelectOrdersResult response = orderRepository.selectOrders(selectOrdersQuery);
        Map<Long, OrderInfo> orderMap = new LinkedHashMap<>();

        for (SelectOrdersDTO row : response.orders()) {
            OrderInfo order = orderMap.computeIfAbsent(
                    row.orderId(),
                    key -> new OrderInfo(
                            row.orderId(),
                            row.customerId(),
                            row.customerName(),
                            row.customerAddress(),
                            row.customerPhoneNumber(),
                            row.orderStatus(),
                            row.cancelMessage(),
                            new LinkedHashMap<>()
                    )
            );

            StoreInfo store = order.stores().computeIfAbsent(
                    row.storeId(),
                    key -> new StoreInfo(row.storeId(),row.storeName(), new ArrayList<>())
            );

            store.orderItems().add(new OrderItemResult(
                    row.menuName(),
                    row.count(),
                    row.menuPrice()
            ));
        }

        List<OrderResult> orders = orderMap.values().stream()
                .map(order -> new OrderResult(
                        order.orderId(),
                        order.customerId(),
                        order.customerName(),
                        order.customerAddress(),
                        order.customerPhoneNumber(),
                        order.orderStatus(),
                        order.cancelMessage(),
                        order.stores().values().stream()
                                .map(store -> new OrderStoreResult(store.storeId(), store.storeName(), store.orderItems()))
                                .toList()
                ))
                .toList();

        return GetOrdersResponse.builder()
                .orders(orders)
                .build();
    }

    @Override
    public GetOrderResponse getOrder(Long orderId) {
        SelectOrderQuery selectOrderQuery = SelectOrderQuery.builder()
                .orderId(orderId)
                .build();

        SelectOrderResult result = orderRepository.selectOrder(selectOrderQuery);
        if (result.order().isEmpty()) {
            throw new EntityNotFoundException();
        }

        SelectOrderDTO firstRow = result.order().get(0);
        Map<Long, StoreInfo> stores = new LinkedHashMap<>();

        for (SelectOrderDTO row : result.order()) {
            StoreInfo store = stores.computeIfAbsent(
                    row.storeId(),
                    key -> new StoreInfo(row.storeId(), row.storeName(), new ArrayList<>())
            );

            store.orderItems().add(new OrderItemResult(
                    row.menuName(),
                    row.count(),
                    row.menuPrice()
            ));
        }

        return GetOrderResponse.builder()
                .orderId(firstRow.orderId())
                .customerId(firstRow.customerId())
                .customerName(firstRow.customerName())
                .customerAddress(firstRow.customerAddress())
                .customerPhoneNumber(firstRow.customerPhoneNumber())
                .orderStatus(firstRow.orderStatus())
                .cancelMessage(firstRow.cancelMessage())
                .stores(stores)
                .build();
    }

    @Override
    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest req) {
        CreateOrderCommand orderCommand = CreateOrderCommand.of(req);
        CreateOrderResult createOrderResult = orderRepository.insertOrder(orderCommand);

        List<CreateOrderStoreCommand> createOrderStoreCommands = req.orders().
                stream().
                map(x -> CreateOrderStoreCommand.of(x, createOrderResult.id()))
                .toList();

        orderStoreService.createOrderStore(createOrderStoreCommands);

        OrderAmountCalculatorResult orderAmountCalculatorResult = orderAmountCalculator(req.orders(), req.totalPoints());
        if (!orderAmountCalculatorResult.result()) {
            throw new InvalidTotalPointsException(ErrorCode.INVALID_TOTAL_POINTS);
        }

        UsePointCommand usePointCommand = UsePointCommand.builder()
                .point(req.totalPoints())
                .customerId(req.customerId())
                .build();

        paymentService.usePoint(usePointCommand);

        return CreateOrderResponse.builder()
                .result(true)
                .build();
    }

    @Override
    @Transactional
    public CancelOrderResponse cancelOrder(CancelOrderRequest req, Long orderId) {
        GetOrderTotalPointsQuery getOrderTotalPointsQuery = GetOrderTotalPointsQuery.builder()
                .orderId(orderId)
                .build();

        GetOrderTotalPointsResult orderTotalPoints = orderStoreService.getOrderTotalPoints(getOrderTotalPointsQuery);

        // customerId 필요
        PaymentCommand.RefundPointCommand.builder()
                        .point(orderTotalPoints.totalPoints())
                        .build();

        CancelOrderCommand command = CancelOrderCommand.of(req, orderId);
        CancelOrderResult cancelOrderResult = orderRepository.cancelOrder(command);



        return CancelOrderResponse.of(cancelOrderResult);
    }

    private OrderAmountCalculatorResult orderAmountCalculator(List<CreateOrderStoreRequest> orders, Long totalPoints) {
        List<CreateOrderItemRequest> result = orders.stream()
                .flatMap(x -> x.orderItem().stream())
                .toList();

        ValidateTotalPointRequest validateTotalPointRequest = ValidateTotalPointRequest.of(result, totalPoints);
        ValidateTotalPointResponse validateTotalPointResponse = orderAmountVerifier.validateTotalPoint(validateTotalPointRequest);

        return OrderAmountCalculatorResult.builder()
                .result(validateTotalPointResponse.result())
                .build();
    }
}