package com.woosung.quick.delivery.repository.order;

import com.woosung.quick.delivery.common.model.command.OrderCommand;
import com.woosung.quick.delivery.common.model.query.OrderQuery;
import com.woosung.quick.delivery.common.model.query.OrderQuery.SelectOrdersQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.*;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.*;

import static com.woosung.quick.delivery.common.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.common.model.query.OrderQuery.*;

public interface OrderRepository {
    SelectOrdersResult selectOrders(SelectOrdersQuery query);
    SelectOrderResult selectOrder(SelectOrderQuery query);
    CreateOrderResult insertOrder(CreateOrderCommand command);
    CancelOrderResult cancelOrder(CancelOrderCommand command);
    AcceptOrderResult acceptOrder(AcceptOrderCommand command);
}
