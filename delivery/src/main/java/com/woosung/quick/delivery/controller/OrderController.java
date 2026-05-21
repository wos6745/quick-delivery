package com.woosung.quick.delivery.controller;

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
    public String getOrders() {
        return "Orders List";
    }

    @GetMapping(path = "/{orderId}")
    public String getOrders(@PathVariable("orderId") long orderId) {
        return MessageFormat.format("Order: {0}", orderId);
    }
}
