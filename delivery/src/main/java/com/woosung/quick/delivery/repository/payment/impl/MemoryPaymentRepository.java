package com.woosung.quick.delivery.repository.payment.impl;

import com.woosung.quick.delivery.common.model.query.PaymentQuery;
import com.woosung.quick.delivery.common.model.query.PaymentQuery.SelectCustomerBalanceQuery;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.SelectCustomerBalanceResult;
import com.woosung.quick.delivery.entity.CustomerWalletEntity;
import com.woosung.quick.delivery.repository.payment.PaymentRepository;
import com.woosung.quick.delivery.repository.payment.jpa.PaymentJpaRepository;
import com.woosung.quick.delivery.repository.payment.jpa.querydsl.JpaQueryPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemoryPaymentRepository implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;
    private final JpaQueryPaymentRepository jpaQueryPaymentRepository;
    @Override
    public SelectCustomerBalanceResult selectCustomerBalance(SelectCustomerBalanceQuery query) {
        CustomerWalletEntity customerWalletEntity = paymentJpaRepository.getCustomerWalletEntityByCustomerId(query.customerId());

        return SelectCustomerBalanceResult.builder()
                .id(customerWalletEntity.getId())
                .customerId(customerWalletEntity.getCustomerId())
                .balance(customerWalletEntity.getPointBalance())
                .build();
    }
}
