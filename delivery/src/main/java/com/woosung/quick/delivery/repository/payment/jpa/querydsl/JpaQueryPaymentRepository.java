package com.woosung.quick.delivery.repository.payment.jpa.querydsl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woosung.quick.delivery.common.model.query.PaymentQuery;
import com.woosung.quick.delivery.common.model.query.PaymentQuery.SelectCustomerBalanceQuery;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.SelectCustomerBalanceResult;
import com.woosung.quick.delivery.entity.CustomerWalletEntity;
import com.woosung.quick.delivery.entity.QCustomerWalletEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.woosung.quick.delivery.entity.QCustomerWalletEntity.customerWalletEntity;

@Repository
@RequiredArgsConstructor
public class JpaQueryPaymentRepository {

    private final JPAQueryFactory jpaQueryFactory;

}
