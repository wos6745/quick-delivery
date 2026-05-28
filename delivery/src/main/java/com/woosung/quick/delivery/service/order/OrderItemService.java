package com.woosung.quick.delivery.service.order;

import com.woosung.quick.delivery.common.model.command.OrderCommand;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderItemCommand;

import java.util.List;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;

public interface OrderItemService {
    CreateOrderItemResponse createOrderItem(List<CreateOrderItemCommand> commands);
}
