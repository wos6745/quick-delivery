package com.woosung.quick.delivery.service;

import com.woosung.quick.delivery.common.model.command.OrderCommand;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderStoreCommand;

import java.util.List;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;


public interface OrderStoreService {
    CreateOrderStoreResponse createOrderStore(List<CreateOrderStoreCommand> commands);
}
