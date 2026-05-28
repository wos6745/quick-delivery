package com.woosung.quick.delivery.repository.payment;

import com.woosung.quick.delivery.common.model.query.PaymentQuery;
import com.woosung.quick.delivery.common.model.query.PaymentQuery.SelectCustomerBalanceQuery;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.SelectCustomerBalanceResult;

public interface PaymentRepository {
    SelectCustomerBalanceResult selectCustomerBalance(SelectCustomerBalanceQuery query);
}
