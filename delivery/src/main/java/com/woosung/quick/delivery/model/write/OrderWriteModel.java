package com.woosung.quick.delivery.model.write;

import lombok.Builder;

public class OrderWriteModel {
    @Builder
    public record CancelOrderResult (boolean result) { }

    @Builder
    public record CreateOrderResult (Long id, boolean result) { }

    @Builder
    public record CreateOrderItemResult (Long id, boolean result) { }
    @Builder
    public record CreateOrderStoreResult (Long id, boolean result) { }
}
