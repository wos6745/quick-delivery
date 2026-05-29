package com.woosung.quick.delivery.payload.request;

import com.woosung.quick.delivery.payload.response.OrderResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.List;

import static com.woosung.quick.delivery.common.Supports.*;

public class OrderRequest {
    public record CancelOrderRequest (OrderStatus orderStatus, String cancelMessage) { }
    public record CreateOrderItemRequest(
            @NotBlank(message = "storeMenuId is required")
            @Schema(description = "매장 메뉴 Id", requiredMode = Schema.RequiredMode.REQUIRED)
            long storeMenuId,
            @NotEmpty(message = "count is required")
            @Schema(description = "매장 메뉴 갯수", requiredMode = Schema.RequiredMode.REQUIRED)
            int count
    ) { }

    public record CreateOrderRequest(
            @NotBlank(message = "orders is not empty")
            @Schema(description = "고객의 주문들", requiredMode = Schema.RequiredMode.REQUIRED)
            List<CreateOrderStoreRequest> orders,

            @NotBlank(message = "customerId is required")
            @Schema(description = "고객 id", requiredMode = Schema.RequiredMode.REQUIRED)
            String customerId,
            @NotBlank(message = "customerName is required")
            @Schema(description = "고객 이름", requiredMode = Schema.RequiredMode.REQUIRED)
            String customerName,
            @NotBlank(message = "customerAddress is required")
            @Schema(description = "고객 주소", requiredMode = Schema.RequiredMode.REQUIRED)
            String customerAddress,
            @NotBlank(message = "customerNumber is required")
            @Schema(description = "고객 전화 번호", requiredMode = Schema.RequiredMode.REQUIRED)
            String customerNumber,
            @NotEmpty(message = "주문 금액 is required")
            @Schema(description = "주문 금액", requiredMode = Schema.RequiredMode.REQUIRED)
            Long totalPoints
    ) {}

    public record CreateOrderStoreRequest(
            @NotBlank(message = "storeId is required")
            @Schema(description = "매장 id", requiredMode = Schema.RequiredMode.REQUIRED)
            long storeId,

            @NotEmpty(message = "customerNumber can't be empty")
            @Schema(description = "고객 매장 메뉴들", requiredMode = Schema.RequiredMode.REQUIRED)
            List<CreateOrderItemRequest> orderItem
    ) { }

    @Builder
    public record ValidateTotalPointRequest (List<CreateOrderItemRequest> list, Long totalPoints) {
        public static ValidateTotalPointRequest of (List<CreateOrderItemRequest> list, Long totalPoints) {
            return ValidateTotalPointRequest.builder()
                    .list(list)
                    .totalPoints(totalPoints)
                    .build();
        }
    }
}
