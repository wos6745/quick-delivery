package com.woosung.quick.delivery.common.model.query;

import lombok.Builder;

import java.util.List;

public class OrderQuery {
    @Builder
    public record SelectOrdersQuery (String customerId) { }

    @Builder
    public record SelectOrderQuery (Long orderId) { }
    @Builder
    public record GetOrderTotalPointsQuery(Long orderId) { }
    @Builder
    public record SelectOrderStoresQuery(Long orderId) { }
    @Builder
    public record GetOrderItemsTotalPointsQuery(List<Long> orderStoreIds) {}
    @Builder
    public record SelectOrderItemsTotalPointsQuery(List<Long> orderStoreIds) {
        public static SelectOrderItemsTotalPointsQuery of(GetOrderItemsTotalPointsQuery query) {
            return SelectOrderItemsTotalPointsQuery.builder()
                    .orderStoreIds(query.orderStoreIds())
                    .build();
        }
    }
}
