package com.woosung.quick.delivery.payload.response;

import com.woosung.quick.delivery.common.model.read.PaymentReadModel;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.SelectCustomerBalanceResult;
import lombok.Builder;

public class PaymentResponse {
    @Builder
    public record GetBalanceResponse(
            Long id,
            String customerId,
            Long balance
    ) {
        public static GetBalanceResponse of(SelectCustomerBalanceResult result) {
            return GetBalanceResponse.builder()
                    .id(result.id())
                    .customerId(result.customerId())
                    .balance(result.balance())
                    .build();
        }
    }

    @Builder
    public record UsePointResponse(
            Long id,
            String customerId,
            boolean result,
            Long balance
    ) {
    }
}
