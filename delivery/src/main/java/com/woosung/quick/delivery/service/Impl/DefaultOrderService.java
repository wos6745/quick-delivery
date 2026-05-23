package com.woosung.quick.delivery.service.Impl;

import com.woosung.quick.delivery.model.response.CreateOrderResponse;
import com.woosung.quick.delivery.payload.request.CreateOrderRequest;
import com.woosung.quick.delivery.repository.OrderItemRepository;
import com.woosung.quick.delivery.repository.OrderRepository;
import com.woosung.quick.delivery.service.OrderItemService;
import com.woosung.quick.delivery.service.OrderService;
import com.woosung.quick.delivery.service.OrderStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
    private final OrderStoreService orderItemService;
    private final OrderRepository orderRepository;

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest req) {
        return null;
    }
}
