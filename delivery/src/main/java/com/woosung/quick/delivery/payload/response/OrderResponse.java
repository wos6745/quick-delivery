package com.woosung.quick.delivery.payload.response;

import com.woosung.quick.delivery.common.Supports.OrderStatus;
import com.woosung.quick.delivery.common.model.info.StoreInfo;
import com.woosung.quick.delivery.common.model.read.OrderReadModel;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CancelOrderResult;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderItemResult;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderResult;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderStoreResult;
import lombok.Builder;

import java.util.List;
import java.util.Map;

public class OrderResponse {
    @Builder
    public record GetOrdersResponse(List<OrderReadModel.OrderResult> orders) { }
    @Builder
    public record  GetOrderResponse(
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
    @Builder
    public record CancelOrderResponse (boolean result) {
        public static CancelOrderResponse of (CancelOrderResult result) {
            return CancelOrderResponse.builder()
                    .result(result.result())
                    .build();
        }
    }

    @Builder
    public record CreateOrderItemResponse (Long id, boolean result) {
        public static CreateOrderItemResponse of (CreateOrderItemResult result) {
            return CreateOrderItemResponse.builder()
                    .id(result.id())
                    .result(result.result())
                    .build();
        }
    }

    @Builder
    public record CreateOrderResponse (Long id, boolean result) {
        public static CreateOrderResponse of (CreateOrderResult result) {
            return CreateOrderResponse.builder()
                    .id(result.id())
                    .result(result.result())
                    .build();
        }
    }

    @Builder
    public record CreateOrderStoreResponse (Long id, boolean result) {
        public static CreateOrderStoreResponse of (CreateOrderStoreResult result) {
            return CreateOrderStoreResponse.builder()
                    .id(result.id())
                    .result(result.result())
                    .build();
        }
    }
}
