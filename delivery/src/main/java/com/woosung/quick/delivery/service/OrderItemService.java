package com.woosung.quick.delivery.service;

import com.woosung.quick.delivery.model.response.CreateOrderItemResponse;
import com.woosung.quick.delivery.payload.request.CreateOrderItemRequest;

public interface OrderItemService {
    CreateOrderItemResponse createOrderItem(CreateOrderItemRequest req);
}
