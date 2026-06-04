package com.woosung.quick.delivery.common.model.write;

import lombok.Builder;

public class OrderWriteModel {
    @Builder
    public record CancelOrderResult (boolean result, Long id, Long orderId) {}
    @Builder
    public record AcceptOrderResult (boolean result, Long id, Long orderId) {}
    @Builder
    public record InsertOrderResult(Long id, boolean result) {}
    @Builder
    public record InsertOrderItemResult(Long id, boolean result) {}
    @Builder
    public record InsertOrderStoreResult(Long id, boolean result) {}
    @Builder
    public record DeliveringOrderResult(Long orderId, boolean result) {}
    @Builder
    public record DeliveredOrderResult(Long orderId, boolean result) {}
}
