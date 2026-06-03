package com.woosung.quick.delivery.common.model.write;

import lombok.Builder;

public class DeliveryWriteModel {
    @Builder
    public record InsertDeliveryResult(boolean result, Long deliveryId){};
}
