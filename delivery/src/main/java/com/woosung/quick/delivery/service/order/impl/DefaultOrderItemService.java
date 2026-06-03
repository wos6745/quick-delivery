package com.woosung.quick.delivery.service.order.impl;

import com.woosung.quick.delivery.common.model.command.OrderCommand.InsertOrderItemCommand;
import com.woosung.quick.delivery.common.model.query.OrderQuery.GetOrderItemsTotalPointsQuery;
import com.woosung.quick.delivery.common.model.query.OrderQuery.SelectOrderItemsTotalPointsQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.GetOrderItemsTotalPointsResult;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrderItemsTotalPointResult;
import com.woosung.quick.delivery.repository.order.OrderItemRepository;
import com.woosung.quick.delivery.service.order.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;

@Service
@RequiredArgsConstructor
public class DefaultOrderItemService implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Override
    public CreateOrderItemResponse createOrderItem(List<InsertOrderItemCommand> commands) {
        commands.forEach(orderItemRepository::insertOrderItem);

        return CreateOrderItemResponse.builder()
                .result(true)
                .build();
    }

    @Override
    public GetOrderItemsTotalPointsResult getOrderItemsTotalPoints(GetOrderItemsTotalPointsQuery query) {
        SelectOrderItemsTotalPointsQuery selectOrderItemsTotalPointsQuery = SelectOrderItemsTotalPointsQuery.of(query);
        SelectOrderItemsTotalPointResult selectOrderItemsTotalPointResult = orderItemRepository.selectOrderItemsTotalPoints(selectOrderItemsTotalPointsQuery);

        return GetOrderItemsTotalPointsResult.of(selectOrderItemsTotalPointResult);
    }
}
