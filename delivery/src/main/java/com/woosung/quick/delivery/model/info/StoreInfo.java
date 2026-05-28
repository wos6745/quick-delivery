package com.woosung.quick.delivery.model.info;

import com.woosung.quick.delivery.model.read.OrderReadModel.OrderItemResult;

import java.util.List;

public record StoreInfo(
        Long storeId,
        String storeName,
        List<OrderItemResult> orderItems) {
}
