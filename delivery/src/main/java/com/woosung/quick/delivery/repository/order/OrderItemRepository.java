package com.woosung.quick.delivery.repository.order;

import com.woosung.quick.delivery.common.model.command.OrderCommand.InsertOrderItemCommand;
import com.woosung.quick.delivery.common.model.query.OrderQuery.SelectOrderItemsTotalPointsQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrderItemsTotalPointResult;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.InsertOrderItemResult;

public interface OrderItemRepository {
    InsertOrderItemResult insertOrderItem(InsertOrderItemCommand command);
    SelectOrderItemsTotalPointResult selectOrderItemsTotalPoints(SelectOrderItemsTotalPointsQuery query);
}
