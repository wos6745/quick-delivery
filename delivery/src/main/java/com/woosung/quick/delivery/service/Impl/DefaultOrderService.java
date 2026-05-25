package com.woosung.quick.delivery.service.Impl;

import com.woosung.quick.delivery.model.response.OrderResponse.GetOrdersResponse;
import com.woosung.quick.delivery.payload.request.OrderRequest;
import com.woosung.quick.delivery.repository.OrderRepository;
import com.woosung.quick.delivery.service.OrderService;
import com.woosung.quick.delivery.service.OrderStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.model.response.OrderResponse.*;
import static com.woosung.quick.delivery.payload.request.OrderRequest.*;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
    private final OrderStoreService orderStoreService;
    private final OrderRepository orderRepository;


    @Override
    public GetOrdersResponse getOrders(String customerId) {
        return null;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest req) {
        CreateOrderCommand orderCommand = CreateOrderCommand.of(req);
        CreateOrderResponse orderRes = orderRepository.insertOrder(orderCommand);

        List<CreateOrderStoreCommand> createOrderStoreCommands = req.orders().
                stream().
                map(x -> CreateOrderStoreCommand.of(x, orderRes.id()))
                .toList();

        orderStoreService.createOrderStore(createOrderStoreCommands);

        return CreateOrderResponse.builder()
                .result(true)
                .build();
    }

    @Override
    public CancelOrderResponse cancelOrderByStore(CancelOrderCommand command) {
        return orderRepository.cancelOrder(command);
    }

    @Override
    public CancelOrderResponse cancelOrderByCustomer(CancelOrderRequest req, Long orderId) {
        CancelOrderCommand command = CancelOrderCommand.of(req, orderId);
        return orderRepository.cancelOrder(command);
    }
}