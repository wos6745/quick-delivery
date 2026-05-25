package com.woosung.quick.delivery.model.command;

import com.woosung.quick.delivery.global.Supports.OrderStatus;
import com.woosung.quick.delivery.payload.request.CancelOrderRequest;
import lombok.Builder;

@Builder
public record CancelOrderCommand (
        Long orderId,
        String cancelMessage,
        OrderStatus orderStatus
)
{
    public static CancelOrderCommand of(CancelOrderRequest req) {
        return CancelOrderCommand.builder()
                .cancelMessage(req.cancelMessage())
                .orderId(req.orderId())
                .orderStatus(req.orderStatus())
                .build();
    }
}
