package com.woosung.quick.delivery.model.response;


import lombok.Builder;

@Builder
public record CreateOrderResponse (
        Long id,
        boolean result
) { }
