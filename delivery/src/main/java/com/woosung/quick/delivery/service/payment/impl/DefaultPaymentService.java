package com.woosung.quick.delivery.service.payment.impl;

import com.woosung.quick.delivery.common.Supports;
import com.woosung.quick.delivery.common.exception.NotEnoughBalanceException;
import com.woosung.quick.delivery.common.model.command.PaymentCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.UpdateBalanceCommand;
import com.woosung.quick.delivery.common.model.query.PaymentQuery;
import com.woosung.quick.delivery.common.model.query.PaymentQuery.SelectCustomerBalanceQuery;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.SelectCustomerBalanceResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.UpdateCustomerBalanceResult;
import com.woosung.quick.delivery.payload.response.PaymentResponse;
import com.woosung.quick.delivery.payload.response.PaymentResponse.*;
import com.woosung.quick.delivery.repository.payment.PaymentRepository;
import com.woosung.quick.delivery.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.woosung.quick.delivery.common.Supports.*;

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
    public UsePointResponse usePoint(String customerId, Long point) {
        UpdateBalanceCommand updateBalanceCommand = UpdateBalanceCommand.builder()
                .customerId(customerId)
                .point(point)
                .build();

        UpdateCustomerBalanceResult updateCustomerBalanceResult = paymentRepository.updateCustomerBalance(updateBalanceCommand);

        return UsePointResponse.builder()
                .result(true)
                .balance(updateCustomerBalanceResult.balance())
                .build();
    }
}
