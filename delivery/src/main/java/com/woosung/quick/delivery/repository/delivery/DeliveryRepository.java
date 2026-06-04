package com.woosung.quick.delivery.repository.delivery;

import com.woosung.quick.delivery.common.model.command.DeliveryCommand.*;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel.*;

public interface DeliveryRepository {
    InsertDeliveryResult insertDelivery(InsertDeliveryCommand command);
    AcceptDeliveryResult acceptDelivery(AcceptDeliveryCommand command);
    PickupDeliveryResult pickDelivery(PickupDeliveryCommand command);
}
