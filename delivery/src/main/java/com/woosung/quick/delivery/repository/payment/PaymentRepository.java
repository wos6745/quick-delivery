package com.woosung.quick.delivery.repository.payment;

import com.woosung.quick.delivery.common.model.command.PaymentCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.UpdateBalanceCommand;
import com.woosung.quick.delivery.common.model.query.PaymentQuery;
import com.woosung.quick.delivery.common.model.query.PaymentQuery.*;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel;
import com.woosung.quick.delivery.common.model.read.PaymentReadModel.*;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.UpdateCustomerBalanceResult;

public interface PaymentRepository {
    SelectCustomerBalanceResult selectCustomerBalance(SelectCustomerBalanceQuery query);
    UpdateCustomerBalanceResult updateCustomerBalance(UpdateBalanceCommand command);
}
