package com.woosung.quick.delivery.service.Impl;

import com.woosung.quick.delivery.model.response.CreateOrderStoreResponse;
import com.woosung.quick.delivery.payload.request.CreateOrderStoreRequest;
import com.woosung.quick.delivery.repository.OrderStoreRepository;
import com.woosung.quick.delivery.service.OrderItemService;
import com.woosung.quick.delivery.service.OrderStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultOrderStoreService implements OrderStoreService {
    private OrderItemService orderItemService;
    private OrderStoreRepository orderStoreRepository;

    @Override
    public CreateOrderStoreResponse createOrderStore(CreateOrderStoreRequest req) {
        return null;
    }
}
