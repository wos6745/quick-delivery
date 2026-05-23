package com.woosung.quick.delivery.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateOrderStoreRequest(
        @NotBlank(message = "storeId is required")
        @Schema(description = "매장 id", requiredMode = Schema.RequiredMode.REQUIRED)
        long storeId,

        @NotEmpty(message = "customerNumber can't be empty")
        @Schema(description = "고객 매장 메뉴들", requiredMode = Schema.RequiredMode.REQUIRED)
        List<CreateOrderItemRequest> orderItem
) { }
