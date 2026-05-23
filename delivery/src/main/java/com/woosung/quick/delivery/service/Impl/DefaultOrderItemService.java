package com.woosung.quick.delivery.service.Impl;

import com.woosung.quick.delivery.model.response.CreateOrderItemResponse;
import com.woosung.quick.delivery.payload.request.CreateOrderItemRequest;
import com.woosung.quick.delivery.repository.OrderItemRepository;
import com.woosung.quick.delivery.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultOrderItemService implements OrderItemService {
    private OrderItemRepository orderItemRepository;

    @Override
    public CreateOrderItemResponse createOrderItem(CreateOrderItemRequest req) {
        return null;
    }
}
