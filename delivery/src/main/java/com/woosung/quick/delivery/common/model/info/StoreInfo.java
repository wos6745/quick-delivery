package com.woosung.quick.delivery.common.model.info;

import com.woosung.quick.delivery.common.model.read.OrderReadModel.OrderItemResult;

import java.util.List;

public record StoreInfo(
        Long storeId,
        String storeName,
        List<OrderItemResult> orderItems) {
}
