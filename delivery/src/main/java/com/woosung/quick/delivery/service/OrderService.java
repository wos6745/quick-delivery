package com.woosung.quick.delivery.service;


import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.payload.response.OrderResponse.*;
import static com.woosung.quick.delivery.payload.request.OrderRequest.*;

public interface OrderService {
    GetOrdersResponse getOrders(String customerId);
    GetOrderResponse getOrder(String orderId);
    CreateOrderResponse createOrder(CreateOrderRequest req);
    CancelOrderResponse cancelOrderByStore(CancelOrderCommand command);
    CancelOrderResponse cancelOrderByCustomer(CancelOrderRequest req, Long orderId);
}
