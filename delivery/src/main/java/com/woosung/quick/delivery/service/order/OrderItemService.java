package com.woosung.quick.delivery.service.order;

import com.woosung.quick.delivery.common.model.command.OrderCommand.InsertOrderItemCommand;
import com.woosung.quick.delivery.common.model.query.OrderQuery.GetOrderItemsTotalPointsQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.GetOrderItemsTotalPointsResult;

import java.util.List;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;

public interface OrderItemService {
    CreateOrderItemResponse createOrderItem(List<InsertOrderItemCommand> commands);
    GetOrderItemsTotalPointsResult getOrderItemsTotalPoints(GetOrderItemsTotalPointsQuery query);
}
