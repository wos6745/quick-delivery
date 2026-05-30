package com.woosung.quick.delivery.common.model.command;

import com.woosung.quick.delivery.common.Supports;
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
    public record CreateOrderCommand (String customerId, String customerName, String customerAddress, String customerPhoneNumber) {
        public static CreateOrderCommand of(CreateOrderRequest req) {
            return CreateOrderCommand.builder()
                    .customerAddress(req.customerAddress())
                    .customerName(req.customerName())
                    .customerId(req.customerId())
                    .customerName(req.customerName())
                    .customerPhoneNumber(req.customerNumber())
                    .build();
        }
    }

    @Builder
    public record CreateOrderItemCommand (Long storeMenuId, int count, Long orderStoreId) {
        public static CreateOrderItemCommand of (CreateOrderItemRequest req, Long orderStoreId) {
            return CreateOrderItemCommand.builder()
                    .count(req.count())
                    .storeMenuId(req.storeMenuId())
                    .orderStoreId(orderStoreId)
                    .build();
        }
    }

    @Builder
    public record CreateOrderStoreCommand (Long orderId, Long storeId, List<CreateOrderItemRequest> orderItemRequests) {
        public static CreateOrderStoreCommand of(CreateOrderStoreRequest req, Long orderId) {
            return CreateOrderStoreCommand.builder()
                    .orderId(orderId)
                    .storeId(req.storeId())
                    .orderItemRequests(req.orderItem())
                    .build();
        }
    }

}
