package com.woosung.quick.delivery.controller;

import com.woosung.quick.delivery.common.Supports;
import com.woosung.quick.delivery.global.QuickDeliveryResponse;
import com.woosung.quick.delivery.payload.response.PaymentResponse;
import com.woosung.quick.delivery.payload.response.PaymentResponse.GetBalanceResponse;
import com.woosung.quick.delivery.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.woosung.quick.delivery.common.Supports.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/balance")
    QuickDeliveryResponse getPayments(@RequestParam("customerId") String customerId) {
        GetBalanceResponse res = paymentService.getBalance(customerId);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }
}
