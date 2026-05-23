package com.woosung.quick.delivery.service;

import com.woosung.quick.delivery.model.response.CreateOrderResponse;
import com.woosung.quick.delivery.payload.request.CreateOrderRequest;

public interface OrderService {
    CreateOrderResponse createOrder(CreateOrderRequest req);
}
