package com.woosung.quick.delivery.service.payment;

import com.woosung.quick.delivery.common.model.command.PaymentCommand;
import com.woosung.quick.delivery.payload.response.PaymentResponse;
import com.woosung.quick.delivery.payload.response.PaymentResponse.GetBalanceResponse;
import com.woosung.quick.delivery.payload.response.PaymentResponse.UsePointResponse;

public interface PaymentService {
    GetBalanceResponse getBalance(String customerId);
    UsePointResponse usePoint(String customerId, Long balance);
}
