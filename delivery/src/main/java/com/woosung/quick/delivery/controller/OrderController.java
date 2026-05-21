package com.woosung.quick.delivery.controller;

import com.woosung.quick.delivery.global.QuickDeliveryResponse;
import com.woosung.quick.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
