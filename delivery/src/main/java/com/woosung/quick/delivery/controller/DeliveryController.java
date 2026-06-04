package com.woosung.quick.delivery.controller;

import com.woosung.quick.delivery.global.QuickDeliveryResponse;
import com.woosung.quick.delivery.payload.request.DeliveryRequest.CallRiderRequest;
import com.woosung.quick.delivery.payload.response.DeliveryResponse;
import com.woosung.quick.delivery.payload.response.DeliveryResponse.AcceptDeliveryResponse;
import com.woosung.quick.delivery.payload.response.DeliveryResponse.CallRiderResponse;
import com.woosung.quick.delivery.payload.response.DeliveryResponse.PickUpDeliveryResponse;
import com.woosung.quick.delivery.service.delivery.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.woosung.quick.delivery.common.Supports.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping()
    public QuickDeliveryResponse callRider(@RequestBody CallRiderRequest req) {
        CallRiderResponse res = deliveryService.callRider(req);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }

    @PatchMapping("/{deliveryId}/accept")
    public QuickDeliveryResponse acceptDelivery(@PathVariable Long deliveryId) {
        AcceptDeliveryResponse res = deliveryService.acceptDelivery(deliveryId);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }

    @PatchMapping("/{deliveryId}/pick-up")
    public QuickDeliveryResponse pickupDelivery(@PathVariable Long deliveryId) {
        PickUpDeliveryResponse res = deliveryService.pickUpDelivery(deliveryId);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }
}
