package com.woosung.quick.delivery.common.model.write;

import lombok.Builder;

public class DeliveryWriteModel {
    @Builder
    public record InsertDeliveryResult(boolean result, Long deliveryId) {}
    @Builder
    public record AcceptDeliveryResult(boolean result, Long deliveryId) {}
    @Builder
    public record PickupDeliveryResult(boolean result, Long deliveryId, Long orderId) {}
    @Builder
    public record CompleteDeliveryResult(boolean result, Long deliveryId, Long orderId) {}
}
