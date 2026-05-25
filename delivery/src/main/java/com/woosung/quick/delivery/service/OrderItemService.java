package com.woosung.quick.delivery.service;

import com.woosung.quick.delivery.model.command.OrderCommand;

import java.util.List;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.model.response.OrderResponse.*;

public interface OrderItemService {
    CreateOrderItemResponse createOrderItem(List<CreateOrderItemCommand> commands);
}
