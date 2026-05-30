package com.woosung.quick.delivery.service.order.impl;

import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderItemCommand;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderStoreCommand;
import com.woosung.quick.delivery.common.model.query.OrderQuery;
import com.woosung.quick.delivery.common.model.query.OrderQuery.GetOrderItemsTotalPointsQuery;
import com.woosung.quick.delivery.common.model.query.OrderQuery.GetOrderTotalPointsQuery;
import com.woosung.quick.delivery.common.model.query.OrderQuery.SelectOrderStoresQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.GetOrderItemsTotalPointsResult;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.GetOrderTotalPointsResult;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrderStoresResult;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderStoreResult;
import com.woosung.quick.delivery.repository.order.OrderStoreRepository;
import com.woosung.quick.delivery.service.order.OrderItemService;
import com.woosung.quick.delivery.service.order.OrderStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;

@Service
@RequiredArgsConstructor
public class DefaultOrderStoreService implements OrderStoreService {
    private final OrderItemService orderItemService;
    private final OrderStoreRepository orderStoreRepository;


    @Override
    public CreateOrderStoreResponse createOrderStore(List<CreateOrderStoreCommand> commands) {
        commands.forEach(x -> {
            CreateOrderStoreResult orderStoreRes = orderStoreRepository.insertOrderStore(x);

            List<CreateOrderItemCommand> orderItemCommands = x.orderItemRequests()
                    .stream()
                    .map(y -> CreateOrderItemCommand.of(y, orderStoreRes.id()))
                    .toList();

            CreateOrderItemResponse orderItem = orderItemService.createOrderItem(orderItemCommands);
        });

        return CreateOrderStoreResponse.builder()
                .result(true)
                .build();
    }

    @Override
    public GetOrderTotalPointsResult getOrderTotalPoints(GetOrderTotalPointsQuery query) {
        SelectOrderStoresQuery selectOrderStoresQuery = SelectOrderStoresQuery.builder()
                .orderId(query.orderId())
                .build();

        SelectOrderStoresResult selectOrderStoresResult = orderStoreRepository.selectOrderStores(selectOrderStoresQuery);

        GetOrderItemsTotalPointsQuery getOrderItemsTotalPointsQuery = GetOrderItemsTotalPointsQuery.builder()
                .orderStoreIds(selectOrderStoresResult.orderStoreIds())
                .build();

        GetOrderItemsTotalPointsResult getOrderItemsTotalPointsResult = orderItemService.getOrderItemsTotalPoints(getOrderItemsTotalPointsQuery);

        return GetOrderTotalPointsResult.builder()
                .totalPoints(getOrderItemsTotalPointsResult.totalPoints())
                .result(true)
                .build();

    }
}
