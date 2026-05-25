package com.woosung.quick.delivery.service;

import com.woosung.quick.delivery.model.command.CancelOrderCommand;
import com.woosung.quick.delivery.model.response.CancelOrderResponse;
import com.woosung.quick.delivery.model.response.CreateOrderResponse;
import com.woosung.quick.delivery.payload.request.CancelOrderRequest;
import com.woosung.quick.delivery.payload.request.CreateOrderRequest;

public interface OrderService {
    CreateOrderResponse createOrder(CreateOrderRequest req);
    CancelOrderResponse cancelOrderByStore(CancelOrderCommand command);
    CancelOrderResponse cancelOrderByCustomer(CancelOrderRequest req);
}
