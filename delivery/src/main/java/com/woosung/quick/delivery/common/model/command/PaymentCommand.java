package com.woosung.quick.delivery.common.model.command;

import lombok.Builder;

public class PaymentCommand {
    @Builder
    public record UpdateBalanceCommand(
            String customerId,
            Long point
    ) { }
}
