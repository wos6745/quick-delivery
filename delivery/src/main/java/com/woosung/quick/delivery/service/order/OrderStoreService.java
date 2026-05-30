package com.woosung.quick.delivery.service.order;

import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderStoreCommand;
import com.woosung.quick.delivery.common.model.query.OrderQuery.GetOrderTotalPointsQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.GetOrderTotalPointsResult;

import java.util.List;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;


public interface OrderStoreService {
    CreateOrderStoreResponse createOrderStore(List<CreateOrderStoreCommand> commands);
    GetOrderTotalPointsResult getOrderTotalPoints(GetOrderTotalPointsQuery query);
}
