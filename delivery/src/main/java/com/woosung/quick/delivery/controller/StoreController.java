package com.woosung.quick.delivery.controller;

import com.woosung.quick.delivery.global.QuickDeliveryResponse;
import com.woosung.quick.delivery.payload.request.StoreRequest.CallRiderRequest;
import com.woosung.quick.delivery.payload.response.StoreResponse;
import com.woosung.quick.delivery.payload.response.StoreResponse.CallRiderResponse;
import com.woosung.quick.delivery.service.delivery.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.woosung.quick.delivery.common.Supports.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stores")
public class StoreController {
    private final DeliveryService deliveryService;

    @PostMapping("/deliveries")
    public QuickDeliveryResponse callRider(@RequestBody CallRiderRequest req) {
        CallRiderResponse res = deliveryService.callRider(req);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }
}
