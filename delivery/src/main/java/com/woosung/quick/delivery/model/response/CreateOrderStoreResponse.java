package com.woosung.quick.delivery.model.response;

import lombok.Builder;

import java.util.List;

@Builder
public record CreateOrderStoreResponse (
        Long id,
        boolean result
) { }
