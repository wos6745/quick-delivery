package com.woosung.quick.delivery.service.order;

import com.woosung.quick.delivery.common.model.command.OrderCommand;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderItemCommand;
import com.woosung.quick.delivery.common.model.query.OrderQuery;
import com.woosung.quick.delivery.common.model.query.OrderQuery.GetOrderItemsTotalPointsQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.GetOrderItemsTotalPointsResult;
import com.woosung.quick.delivery.payload.request.OrderRequest;
import com.woosung.quick.delivery.payload.request.OrderRequest.ValidateTotalPointRequest;

import java.util.List;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;

public interface OrderItemService {
    CreateOrderItemResponse createOrderItem(List<CreateOrderItemCommand> commands);
    GetOrderItemsTotalPointsResult getOrderItemsTotalPoints(GetOrderItemsTotalPointsQuery query);
}
