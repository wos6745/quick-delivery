package com.woosung.quick.delivery.model.response;

import lombok.Builder;

@Builder
public record CreateOrderItemResponse (
        Long id,
        boolean result
)
{ }
