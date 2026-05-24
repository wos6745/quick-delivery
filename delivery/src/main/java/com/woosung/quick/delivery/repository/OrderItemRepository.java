package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.model.command.CreateOrderItemCommand;
import com.woosung.quick.delivery.model.response.CreateOrderItemResponse;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemRepository {
    CreateOrderItemResponse insertOrderItem(CreateOrderItemCommand command);
}
