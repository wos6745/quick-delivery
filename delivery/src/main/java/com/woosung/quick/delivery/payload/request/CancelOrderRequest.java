package com.woosung.quick.delivery.payload.request;

import com.woosung.quick.delivery.global.Supports;
import com.woosung.quick.delivery.global.Supports.OrderStatus;

public record CancelOrderRequest (
        OrderStatus orderStatus,
        String cancelMessage
) { }
