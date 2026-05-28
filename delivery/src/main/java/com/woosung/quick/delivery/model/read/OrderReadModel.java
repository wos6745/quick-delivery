package com.woosung.quick.delivery.model.read;

import com.querydsl.core.annotations.QueryProjection;
import com.woosung.quick.delivery.global.Supports.OrderStatus;
import lombok.Builder;

import java.util.List;

public class OrderReadModel {

    public record OrderResult(
            String orderId,
            String customerId,
            String customerName,
            String customerAddress,
            String customerPhoneNumber,
            OrderStatus orderStatus,
            String cancelMessage,
            List<OrderStoreResult> stores
    ) { }

    public record OrderStoreResult(
            Long storeId,
            String storeName,
            List<OrderItemResult> orderItems
    ) { }

    public record OrderItemResult(
            String menuName,
            Integer count,
            Long menuPrice
    ) { }

    public record SelectOrdersDTO(
            String orderId,
            String customerId,
            String customerName,
            String customerAddress,
            String customerPhoneNumber,
            OrderStatus orderStatus,
            String cancelMessage,
            Long storeId,
            String storeName,
            Long menuId,
            String menuName,
            Integer count,
            Long menuPrice
    ) {
        @QueryProjection
        public SelectOrdersDTO { }
    }

    public record SelectOrderDTO(
            String orderId,
            String customerId,
            String customerName,
            String customerAddress,
            String customerPhoneNumber,
            OrderStatus orderStatus,
            String cancelMessage,
            Long storeId,
            String storeName,
            Long menuId,
            String menuName,
            Integer count,
            Long menuPrice
    ) {
        @QueryProjection
        public SelectOrderDTO { }
    }

    @Builder
    public record SelectOrdersResult(List<SelectOrdersDTO> orders) { }

    @Builder
    public record SelectOrderResult(
            List<SelectOrderDTO> order
    ) {
    }
}
