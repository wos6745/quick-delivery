package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.model.command.OrderCommand;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.model.response.OrderResponse.*;

public interface OrderStoreRepository {
    CreateOrderStoreResponse insertOrderStore(CreateOrderStoreCommand command);
}
