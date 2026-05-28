package com.woosung.quick.delivery.common.model.read;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;

public class PaymentReadModel {
    @Builder
    public record SelectCustomerBalanceResult(
            Long id,
            String customerId,
            Long balance
    ) {
    }
}
