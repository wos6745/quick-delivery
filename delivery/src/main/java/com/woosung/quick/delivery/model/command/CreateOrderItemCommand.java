package com.woosung.quick.delivery.model.command;

import com.woosung.quick.delivery.payload.request.CreateOrderItemRequest;
import lombok.Builder;

@Builder
public record CreateOrderItemCommand (
    Long storeMenuId,
    int count,
    Long orderStoreId
) {
    public static CreateOrderItemCommand of (CreateOrderItemRequest req, Long orderStoreId) {
        return CreateOrderItemCommand.builder()
                .count(req.count())
                .storeMenuId(req.storeMenuId())
                .orderStoreId(orderStoreId)
                .build();
    }
}
