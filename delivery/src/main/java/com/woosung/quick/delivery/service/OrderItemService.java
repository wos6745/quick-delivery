package com.woosung.quick.delivery.service;

import com.woosung.quick.delivery.model.command.CreateOrderItemCommand;
import com.woosung.quick.delivery.model.response.CreateOrderItemResponse;
import com.woosung.quick.delivery.payload.request.CreateOrderItemRequest;

import java.util.List;

public interface OrderItemService {
    CreateOrderItemResponse createOrderItem(List<CreateOrderItemCommand> commands);
}
