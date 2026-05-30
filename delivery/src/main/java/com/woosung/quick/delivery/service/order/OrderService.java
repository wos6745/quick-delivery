package com.woosung.quick.delivery.service.order;


import static com.woosung.quick.delivery.payload.response.OrderResponse.*;
import static com.woosung.quick.delivery.payload.request.OrderRequest.*;

public interface OrderService {
    GetOrdersResponse getOrders(String customerId);
    GetOrderResponse getOrder(Long orderId);
    CreateOrderResponse createOrder(CreateOrderRequest req);
    CancelOrderResponse cancelOrder(CancelOrderRequest req, Long orderId);
}
