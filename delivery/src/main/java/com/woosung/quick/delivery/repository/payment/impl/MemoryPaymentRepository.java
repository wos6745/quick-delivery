package com.woosung.quick.delivery.repository.payment.impl;

import com.woosung.quick.delivery.common.model.command.PaymentCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.DeductCustomerBalanceCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.RefundCustomerPointCommand;
import com.woosung.quick.delivery.common.model.query.PaymentQuery.SelectCustomerBalanceQuery;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.SelectCustomerBalanceResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.DeductCustomerBalanceResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.RefundCustomerPointResult;
import com.woosung.quick.delivery.entity.CustomerWalletEntity;
import com.woosung.quick.delivery.repository.payment.PaymentRepository;
import com.woosung.quick.delivery.repository.payment.jpa.PaymentJpaRepository;
import com.woosung.quick.delivery.repository.payment.jpa.querydsl.JpaQueryPaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemoryPaymentRepository implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;
    private final JpaQueryPaymentRepository jpaQueryPaymentRepository;
    @Override
    public SelectCustomerBalanceResult selectCustomerBalance(SelectCustomerBalanceQuery query) {
        CustomerWalletEntity customerWalletEntity = paymentJpaRepository.findByCustomerId(query.customerId())
                .orElseThrow(EntityNotFoundException::new);

        return SelectCustomerBalanceResult.builder()
                .id(customerWalletEntity.getId())
                .customerId(customerWalletEntity.getCustomerId())
                .balance(customerWalletEntity.getPointBalance())
                .build();
    }

    @Override
    public DeductCustomerBalanceResult deductCustomerBalance(DeductCustomerBalanceCommand command) {
        CustomerWalletEntity customerWalletEntity = paymentJpaRepository.findByCustomerId(command.customerId())
                .orElseThrow(EntityNotFoundException::new);

        customerWalletEntity.deduct(command.point());

        return DeductCustomerBalanceResult.builder()
                .id(customerWalletEntity.getId())
                .customerId(customerWalletEntity.getCustomerId())
                .balance(customerWalletEntity.getPointBalance())
                .build();
    }

    @Override
    public RefundCustomerPointResult refundCustomerPoint(RefundCustomerPointCommand command) {
        CustomerWalletEntity customerWalletEntity = paymentJpaRepository.findByCustomerId(command.customerId())
                .orElseThrow(EntityNotFoundException::new);

        customerWalletEntity.refund(command.point());

        return RefundCustomerPointResult.builder()
                .balance(customerWalletEntity.getPointBalance())
                .customerId(command.customerId())
                .build();
    }
}
