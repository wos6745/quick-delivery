package com.woosung.quick.delivery.service;

import com.woosung.quick.delivery.model.response.CreateOrderResponse;
import com.woosung.quick.delivery.model.response.CreateOrderStoreResponse;
import com.woosung.quick.delivery.payload.request.CreateOrderStoreRequest;


public interface OrderStoreService {
    CreateOrderStoreResponse createOrderStore(CreateOrderStoreRequest req);
}
