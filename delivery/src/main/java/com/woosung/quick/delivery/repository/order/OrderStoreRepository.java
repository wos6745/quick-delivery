package com.woosung.quick.delivery.repository.order;

import com.woosung.quick.delivery.common.model.command.OrderCommand;
import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderStoreCommand;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderStoreResult;

public interface OrderStoreRepository {
    CreateOrderStoreResult insertOrderStore(CreateOrderStoreCommand command);
}
