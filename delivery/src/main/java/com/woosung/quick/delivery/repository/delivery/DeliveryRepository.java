package com.woosung.quick.delivery.repository.delivery;

import com.woosung.quick.delivery.common.model.command.DeliveryCommand.InsertDeliveryCommand;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel.InsertDeliveryResult;

public interface DeliveryRepository {
    InsertDeliveryResult insertDelivery(InsertDeliveryCommand command);
}
