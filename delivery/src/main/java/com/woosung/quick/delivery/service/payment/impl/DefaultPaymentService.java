package com.woosung.quick.delivery.service.payment.impl;

import com.woosung.quick.delivery.common.model.query.PaymentQuery;
import com.woosung.quick.delivery.common.model.query.PaymentQuery.SelectCustomerBalanceQuery;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.SelectCustomerBalanceResult;
import com.woosung.quick.delivery.payload.response.PaymentResponse;
import com.woosung.quick.delivery.payload.response.PaymentResponse.GetBalanceResponse;
import com.woosung.quick.delivery.repository.payment.PaymentRepository;
import com.woosung.quick.delivery.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
