package com.woosung.quick.delivery.payload.response;

import lombok.Builder;

public class DeliveryResponse {
    @Builder
    public record CallRiderResponse(Long deliveryId) {}
    @Builder
    public record AcceptDeliveryResponse(Long deliveryId) {}
    @Builder
    public record PickUpDeliveryResponse(Long deliveryId) {}
    @Builder
    public record CompleteDeliveryResponse(Long deliveryId) {}
}
