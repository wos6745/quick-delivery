package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.model.read.OrderReadModel;
import com.woosung.quick.delivery.model.read.OrderReadModel.SelectOrderResult;
import com.woosung.quick.delivery.model.read.OrderReadModel.SelectOrdersResult;
import com.woosung.quick.delivery.model.write.OrderWriteModel;
import com.woosung.quick.delivery.model.write.OrderWriteModel.CancelOrderResult;
import com.woosung.quick.delivery.model.write.OrderWriteModel.CreateOrderResult;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.model.query.OrderQuery.*;

public interface OrderRepository {
    SelectOrdersResult selectOrders(SelectOrdersQuery query);
    SelectOrderResult selectOrder(SelectOrderQuery query);
    CreateOrderResult insertOrder(CreateOrderCommand command);
    CancelOrderResult cancelOrder(CancelOrderCommand command);
}
