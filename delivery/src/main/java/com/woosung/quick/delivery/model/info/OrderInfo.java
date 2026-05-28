package com.woosung.quick.delivery.model.info;

import com.woosung.quick.delivery.global.Supports.OrderStatus;

import java.util.Map;

public record OrderInfo(
        String orderId,
        String customerId,
        String customerName,
        String customerAddress,
        String customerPhoneNumber,
        OrderStatus orderStatus,
        String cancelMessage,
        Map<Long, StoreInfo> stores
) {
}
