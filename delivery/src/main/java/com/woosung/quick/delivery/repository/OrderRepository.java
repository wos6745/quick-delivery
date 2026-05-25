package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.model.query.OrderQuery;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.model.query.OrderQuery.*;
import static com.woosung.quick.delivery.model.response.OrderResponse.*;

public interface OrderRepository {
    GetOrdersResponse selectOrders(SelectOrdersQuery query);
    CreateOrderResponse insertOrder(CreateOrderCommand command);
    CancelOrderResponse cancelOrder(CancelOrderCommand command);
}
