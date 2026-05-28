package com.woosung.quick.delivery.service;

import java.util.List;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.payload.response.OrderResponse.*;

public interface OrderItemService {
    CreateOrderItemResponse createOrderItem(List<CreateOrderItemCommand> commands);
}
