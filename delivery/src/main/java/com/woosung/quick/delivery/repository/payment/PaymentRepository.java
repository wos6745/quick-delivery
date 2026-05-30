package com.woosung.quick.delivery.repository.payment;

import com.woosung.quick.delivery.common.model.command.PaymentCommand.DeductCustomerBalanceCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.RefundCustomerPointCommand;
import com.woosung.quick.delivery.common.model.query.PaymentQuery.*;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.*;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.DeductCustomerBalanceResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.RefundCustomerPointResult;

public interface PaymentRepository {
    SelectCustomerBalanceResult selectCustomerBalance(SelectCustomerBalanceQuery query);
    DeductCustomerBalanceResult deductCustomerBalance(DeductCustomerBalanceCommand command);
    RefundCustomerPointResult refundCustomerPoint(RefundCustomerPointCommand command);

}
