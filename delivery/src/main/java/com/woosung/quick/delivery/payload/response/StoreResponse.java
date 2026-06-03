package com.woosung.quick.delivery.payload.response;

import lombok.Builder;

public class StoreResponse {
    @Builder
    public record CallRiderResponse(Long deliveryId) { }
}
