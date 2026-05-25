package com.woosung.quick.delivery.controller;

import com.woosung.quick.delivery.global.QuickDeliveryResponse;
import com.woosung.quick.delivery.global.Supports;
import com.woosung.quick.delivery.global.Supports.ResultCode;
import com.woosung.quick.delivery.model.response.CancelOrderResponse;
import com.woosung.quick.delivery.model.response.CreateOrderResponse;
import com.woosung.quick.delivery.payload.request.CancelOrderRequest;
import com.woosung.quick.delivery.payload.request.CreateOrderRequest;
import com.woosung.quick.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    public final OrderService orderService;

    @GetMapping
    public QuickDeliveryResponse getOrders() {
        return QuickDeliveryResponse.builder().build();
    }

    @GetMapping(path = "/{orderId}")
    public QuickDeliveryResponse getOrders(@PathVariable("orderId") long orderId) {
        return QuickDeliveryResponse.builder().build();
    }
    @PostMapping
    public QuickDeliveryResponse createOrder(@RequestBody CreateOrderRequest req) {
        CreateOrderResponse result = orderService.createOrder(req);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(result)
                .build();

    }

    @PatchMapping(path = "/{orderId}")
    public QuickDeliveryResponse cancelOrder(@RequestBody CancelOrderRequest req,
                                             @PathVariable("orderId") Long orderId) {
        CancelOrderResponse result = orderService.cancelOrderByCustomer(req, orderId);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(result)
                .build();
    }
}
