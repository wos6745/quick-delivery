package com.woosung.quick.delivery.payload.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateOrderItemRequest(
        @NotBlank(message = "storeMenuId is required")
        @Schema(description = "매장 메뉴 Id", requiredMode = Schema.RequiredMode.REQUIRED)
        long storeMenuId,
        @NotEmpty(message = "count is required")
        @Schema(description = "매장 메뉴 갯수", requiredMode = Schema.RequiredMode.REQUIRED)
        int count
) { }
