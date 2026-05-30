package com.woosung.quick.delivery.common.model.write;

import lombok.Builder;

public class PaymentWriteModel {
    @Builder
    public record UsePointResult(
            Long id,
            String customerId,
            boolean result,
            Long balance
    ) {
    }
    @Builder
    public record DeductCustomerBalanceResult(
            Long id,
            String customerId,
            Long balance
    ) { }

    @Builder
    public record RefundPointResult(String customerId, Long balance) {
        public static RefundPointResult of(RefundCustomerPointResult result) {
            return RefundPointResult.builder()
                    .customerId(result.customerId())
                    .balance(result.balance())
                    .build();
        }
    }
    @Builder
    public record RefundCustomerPointResult(String customerId, Long balance) { }

}
