package com.woosung.quick.delivery.model.command;

import com.woosung.quick.delivery.payload.request.CreateOrderItemRequest;
import com.woosung.quick.delivery.payload.request.CreateOrderStoreRequest;
import lombok.Builder;

import java.util.List;

@Builder
public record CreateOrderStoreCommand (
        Long orderId,
        Long storeId,
        List<CreateOrderItemRequest> orderItemRequests
) {
    public static CreateOrderStoreCommand of(CreateOrderStoreRequest req, Long orderId) {
        return CreateOrderStoreCommand.builder()
                .orderId(orderId)
                .storeId(req.storeId())
                .orderItemRequests(req.orderItem())
                .build();
    }
}
