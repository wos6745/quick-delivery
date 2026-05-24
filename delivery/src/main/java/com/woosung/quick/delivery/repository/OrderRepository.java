package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.model.command.CreateOrderCommand;
import com.woosung.quick.delivery.model.response.CreateOrderResponse;

public interface OrderRepository {
    CreateOrderResponse insertOrder(CreateOrderCommand command);
}
