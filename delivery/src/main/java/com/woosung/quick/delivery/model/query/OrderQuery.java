package com.woosung.quick.delivery.model.query;

import lombok.Builder;

public class OrderQuery {
    @Builder
    public record SelectOrdersQuery (String customerId) { }

    @Builder
    public record SelectOrderQuery (String orderId) { }
}
