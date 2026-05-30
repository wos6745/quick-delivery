package com.woosung.quick.delivery.service.payment;

import com.woosung.quick.delivery.common.model.command.PaymentCommand;
import com.woosung.quick.delivery.common.model.command.PaymentCommand.UsePointCommand;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.RefundPointResult;
import com.woosung.quick.delivery.common.model.write.PaymentWriteModel.UsePointResult;
import com.woosung.quick.delivery.payload.response.PaymentResponse.GetBalanceResponse;

import static com.woosung.quick.delivery.common.model.command.PaymentCommand.*;

public interface PaymentService {
    GetBalanceResponse getBalance(String customerId);
    UsePointResult usePoint(UsePointCommand command);
    RefundPointResult refundPoint(RefundPointCommand command);
}
