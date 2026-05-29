package com.woosung.quick.delivery.common.model.write;

import lombok.Builder;

public class PaymentWriteModel {
    @Builder
    public record UpdateCustomerBalanceResult(
            Long id,
            String customerId,
            Long balance
    ) {
    }
}
