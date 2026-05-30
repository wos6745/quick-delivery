package com.woosung.quick.delivery.common.model.read;

import com.querydsl.core.annotations.QueryProjection;
import com.woosung.quick.delivery.common.Supports.OrderStatus;
import lombok.Builder;

import java.util.List;

public class OrderReadModel {

    @Builder
    public record OrderAmountCalculatorResult(boolean result) { }

    public record OrderResult(
            Long orderId,
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
            Long orderId,
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
            Long orderId,
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

    @Builder
    public record GetOrderTotalPointsResult(boolean result, Long totalPoints) { }

    @Builder
    public record SelectOrderStoresResult(List<Long> orderStoreIds) { }
    @Builder
    public record GetOrderItemsTotalPointsResult(Long totalPoints) {
        public static GetOrderItemsTotalPointsResult of(SelectOrderItemsTotalPointResult result) {
            return GetOrderItemsTotalPointsResult.builder()
                    .totalPoints(result.totalPoints())
                    .build();
        }
    }
    @Builder
    public record SelectOrderItemsTotalPointResult(Long totalPoints) {}
}
