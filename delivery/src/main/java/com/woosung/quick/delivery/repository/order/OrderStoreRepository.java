package com.woosung.quick.delivery.repository.order;

import com.woosung.quick.delivery.common.model.command.OrderCommand.InsertOrderStoreCommand;
import com.woosung.quick.delivery.common.model.query.OrderQuery.SelectOrderStoresQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrderStoresResult;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.InsertOrderStoreResult;

public interface OrderStoreRepository {
    InsertOrderStoreResult insertOrderStore(InsertOrderStoreCommand command);
    SelectOrderStoresResult selectOrderStores(SelectOrderStoresQuery query);
}
