package com.woosung.quick.delivery.model.response;

import lombok.Builder;

public class OrderResponse {
    @Builder
    public record CancelOrderResponse (boolean result) { }

    @Builder
    public record CreateOrderItemResponse (Long id, boolean result) { }

    @Builder
    public record CreateOrderResponse (Long id, boolean result) { }

    @Builder
    public record CreateOrderStoreResponse (Long id, boolean result) { }
    @Builder
    public record GetOrdersResponse () { }
}
