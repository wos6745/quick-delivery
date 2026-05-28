package com.woosung.quick.delivery.service.order;


import com.woosung.quick.delivery.common.model.command.OrderCommand;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CancelOrderCommand;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;
import static com.woosung.quick.delivery.payload.request.OrderRequest.*;

public interface OrderService {
    GetOrdersResponse getOrders(String customerId);
    GetOrderResponse getOrder(String orderId);
    CreateOrderResponse createOrder(CreateOrderRequest req);
    CancelOrderResponse cancelOrderByStore(CancelOrderCommand command);
    CancelOrderResponse cancelOrderByCustomer(CancelOrderRequest req, Long orderId);
}
