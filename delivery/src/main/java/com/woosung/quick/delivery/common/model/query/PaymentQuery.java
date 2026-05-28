package com.woosung.quick.delivery.common.model.query;

import lombok.Builder;

public class PaymentQuery {
    @Builder
    public record SelectCustomerBalanceQuery(String customerId) { }
}
