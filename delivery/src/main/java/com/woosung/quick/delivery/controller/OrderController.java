package com.woosung.quick.delivery.controller;

import com.woosung.quick.delivery.global.QuickDeliveryResponse;
import com.woosung.quick.delivery.global.Supports.ResultCode;

import com.woosung.quick.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;
import static com.woosung.quick.delivery.payload.request.OrderRequest.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    public final OrderService orderService;

    @GetMapping
    public QuickDeliveryResponse getOrders(@RequestParam(name = "customerId") String customerId) {
        GetOrdersResponse res = orderService.getOrders(customerId);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }

    @GetMapping(path = "/{orderId}")
    public QuickDeliveryResponse getOrder(@PathVariable("orderId") String orderId) {
        GetOrderResponse res = orderService.getOrder(orderId);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }
    @PostMapping
    public QuickDeliveryResponse createOrder(@RequestBody CreateOrderRequest req) {
        CreateOrderResponse res = orderService.createOrder(req);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();

    }

    @PatchMapping(path = "/{orderId}")
    public QuickDeliveryResponse cancelOrder(@RequestBody CancelOrderRequest req,
                                             @PathVariable("orderId") Long orderId) {
        CancelOrderResponse res = orderService.cancelOrderByCustomer(req, orderId);

        return QuickDeliveryResponse.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getInfoMessage())
                .data(res)
                .build();
    }
}
