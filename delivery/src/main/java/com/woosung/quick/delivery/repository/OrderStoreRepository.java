package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.model.command.CreateOrderStoreCommand;
import com.woosung.quick.delivery.model.response.CreateOrderStoreResponse;

import java.util.List;

public interface OrderStoreRepository {
    CreateOrderStoreResponse insertOrderStore(CreateOrderStoreCommand command);
}
