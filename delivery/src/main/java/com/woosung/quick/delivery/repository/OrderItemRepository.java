package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.model.write.OrderWriteModel;
import com.woosung.quick.delivery.model.write.OrderWriteModel.CreateOrderItemResult;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;

public interface OrderItemRepository {
    CreateOrderItemResult insertOrderItem(CreateOrderItemCommand command);
}
