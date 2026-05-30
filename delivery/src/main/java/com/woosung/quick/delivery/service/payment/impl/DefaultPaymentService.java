package com.woosung.quick.delivery.service.payment.impl;

import com.woosung.quick.delivery.common.exception.NotEnoughBalanceException;
import com.woosung.quick.delivery.common.model.command.PaymentCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.DeductCustomerBalanceCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.RefundCustomerPointCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.RefundPointCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.UsePointCommand;
import com.woosung.quick.delivery.common.model.query.PaymentQuery.SelectCustomerBalanceQuery;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.SelectCustomerBalanceResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.RefundCustomerPointResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.RefundPointResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.DeductCustomerBalanceResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.UsePointResult;
import com.woosung.quick.delivery.payload.response.PaymentResponse.*;
import com.woosung.quick.delivery.repository.payment.PaymentRepository;
import com.woosung.quick.delivery.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultPaymentService implements PaymentService {
    private final PaymentRepository paymentRepository;
    @Override
    public GetBalanceResponse getBalance(String customerId) {
        SelectCustomerBalanceQuery selectCustomerBalanceQuery = SelectCustomerBalanceQuery.builder()
                .customerId(customerId)
                .build();

        SelectCustomerBalanceResult selectCustomerBalanceResult = paymentRepository.selectCustomerBalance(selectCustomerBalanceQuery);

        return GetBalanceResponse.of(selectCustomerBalanceResult);
    }

    @Override
    @Retryable(
            value = OptimisticLockingFailureException.class,
            maxRetries = 3,
            excludes = NotEnoughBalanceException.class
    )
    @Transactional
    public UsePointResult usePoint(UsePointCommand command) {
        DeductCustomerBalanceCommand deductCustomerBalanceCommand = DeductCustomerBalanceCommand.builder()
                .customerId(command.customerId())
                .point(command.point())
                .build();

        DeductCustomerBalanceResult deductCustomerBalanceResult = paymentRepository.deductCustomerBalance(deductCustomerBalanceCommand);

        return UsePointResult.builder()
                .result(true)
                .balance(deductCustomerBalanceResult.balance())
                .build();
    }

    @Override
    @Retryable(
            value = OptimisticLockingFailureException.class,
            maxRetries = 3,
            excludes = NotEnoughBalanceException.class
    )
    @Transactional
    public RefundPointResult refundPoint(RefundPointCommand command) {
        RefundCustomerPointCommand refundCustomerPointCommand = RefundCustomerPointCommand.of(command);
        RefundCustomerPointResult refundCustomerPointResult = paymentRepository.refundCustomerPoint(refundCustomerPointCommand);

        return RefundPointResult.of(refundCustomerPointResult);
    }
}
