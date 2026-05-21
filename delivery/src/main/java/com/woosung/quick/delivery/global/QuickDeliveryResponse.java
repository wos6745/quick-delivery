package com.woosung.quick.delivery.global;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuickDeliveryResponse {
    @Schema(description = "response code")
    private final int code;
    @Schema(description = "response message")
    private final String message;
    @Schema(description = "response body data")
    private final Object data;

    @Builder
    public QuickDeliveryResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
