package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.model.write.OrderWriteModel;
import com.woosung.quick.delivery.model.write.OrderWriteModel.CreateOrderStoreResult;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;

public interface OrderStoreRepository {
    CreateOrderStoreResult insertOrderStore(CreateOrderStoreCommand command);
}
