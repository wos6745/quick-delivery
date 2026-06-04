package com.woosung.quick.delivery.common.model.command;

import com.woosung.quick.delivery.common.Supports.OrderStatus;
import lombok.Builder;

import java.util.List;

import static com.woosung.quick.delivery.payload.request.OrderRequest.*;

public class OrderCommand {
    @Builder
    public record CancelOrderCommand (Long orderId, String cancelMessage, OrderStatus orderStatus) {
        public static CancelOrderCommand of(CancelOrderRequest req, Long orderId) {
            return CancelOrderCommand.builder()
                    .cancelMessage(req.cancelMessage())
                    .orderId(orderId)
                    .orderStatus(req.orderStatus())
                    .build();
        }
    }

    @Builder
    public record AcceptOrderCommand(Long orderId, OrderStatus orderStatus) {
        public static AcceptOrderCommand of(AcceptOrderRequest req, Long orderId) {
            return AcceptOrderCommand.builder()
                    .orderId(orderId)
                    .orderStatus(req.orderStatus())
                    .build();
        }
    }

    @Builder
    public record InsertOrderCommand(String customerId, String customerName, String customerAddress, String customerPhoneNumber) {
        public static InsertOrderCommand of(CreateOrderRequest req) {
            return InsertOrderCommand.builder()
                    .customerAddress(req.customerAddress())
                    .customerName(req.customerName())
                    .customerId(req.customerId())
                    .customerName(req.customerName())
                    .customerPhoneNumber(req.customerNumber())
                    .build();
        }
    }

    @Builder
    public record InsertOrderItemCommand(Long storeMenuId, int count, Long orderStoreId) {
        public static InsertOrderItemCommand of (CreateOrderItemRequest req, Long orderStoreId) {
            return InsertOrderItemCommand.builder()
                    .count(req.count())
                    .storeMenuId(req.storeMenuId())
                    .orderStoreId(orderStoreId)
                    .build();
        }
    }

    @Builder
    public record InsertOrderStoreCommand(Long orderId, Long storeId, List<CreateOrderItemRequest> orderItemRequests) {
        public static InsertOrderStoreCommand of(CreateOrderStoreRequest req, Long orderId) {
            return InsertOrderStoreCommand.builder()
                    .orderId(orderId)
                    .storeId(req.storeId())
                    .orderItemRequests(req.orderItem())
                    .build();
        }
    }
    @Builder
    public record DeliveringOrderCommand(Long orderId) {}
    @Builder
    public record DeliveredOrderCommand(Long orderId) {}
}
