package com.woosung.quick.delivery.common.model.command;

import lombok.Builder;

public class PaymentCommand {
    @Builder
    public record UsePointCommand(String customerId, Long point) {}
    @Builder
    public record DeductCustomerBalanceCommand(
            String customerId,
            Long point
    ) { }

    @Builder
    public record RefundPointCommand(String customerId, Long point) {}
    @Builder
    public record RefundCustomerPointCommand(String customerId, Long point) {
        public static RefundCustomerPointCommand of(RefundPointCommand command) {
            return RefundCustomerPointCommand.builder()
                    .point(command.point())
                    .customerId(command.customerId())
                    .build();
        }
    }
}
