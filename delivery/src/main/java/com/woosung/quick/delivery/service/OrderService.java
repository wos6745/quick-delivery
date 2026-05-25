package com.woosung.quick.delivery.service;

import com.woosung.quick.delivery.payload.request.OrderRequest;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.model.response.OrderResponse.*;
import static com.woosung.quick.delivery.payload.request.OrderRequest.*;

public interface OrderService {
    CreateOrderResponse createOrder(CreateOrderRequest req);
    CancelOrderResponse cancelOrderByStore(CancelOrderCommand command);
    CancelOrderResponse cancelOrderByCustomer(CancelOrderRequest req, Long orderId);
    GetOrdersResponse getOrders(String customerId);
}
