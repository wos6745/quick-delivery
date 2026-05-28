package com.woosung.quick.delivery.service.payment;

import com.woosung.quick.delivery.payload.response.PaymentResponse;
import com.woosung.quick.delivery.payload.response.PaymentResponse.GetBalanceResponse;

public interface PaymentService {
    GetBalanceResponse getBalance(String customerId);
}
