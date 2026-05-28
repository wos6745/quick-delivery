package com.woosung.quick.delivery.repository.order;

import com.woosung.quick.delivery.common.model.command.OrderCommand;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderItemCommand;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderItemResult;

public interface OrderItemRepository {
    CreateOrderItemResult insertOrderItem(CreateOrderItemCommand command);
}
