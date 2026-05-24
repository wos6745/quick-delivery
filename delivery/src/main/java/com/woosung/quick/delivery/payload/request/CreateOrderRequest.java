package com.woosung.quick.delivery.payload.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.NoArgsConstructor;

import java.util.List;

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
        String customerNumber
) {}



