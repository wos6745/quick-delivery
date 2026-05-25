package com.woosung.quick.delivery.model.response;


import lombok.Builder;

@Builder
public record CancelOrderResponse (
    boolean result
) { }
