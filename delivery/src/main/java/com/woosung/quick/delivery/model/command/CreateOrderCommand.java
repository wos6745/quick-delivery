package com.woosung.quick.delivery.model.command;

import com.woosung.quick.delivery.payload.request.CreateOrderRequest;
import lombok.Builder;
import lombok.Getter;

@Builder
public record CreateOrderCommand (
        String customerId,
        String customerName,
        String customerAddress,
        String customerPhoneNumber) {

    public static CreateOrderCommand of(CreateOrderRequest req) {
        return CreateOrderCommand.builder()
                .customerAddress(req.customerAddress())
                .customerName(req.customerName())
                .customerId(req.customerId())
                .customerName(req.customerName())
                .build();
    }

}
