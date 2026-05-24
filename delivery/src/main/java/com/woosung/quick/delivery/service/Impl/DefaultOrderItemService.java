package com.woosung.quick.delivery.service.Impl;

import com.woosung.quick.delivery.entity.OrderItemEntity;
import com.woosung.quick.delivery.entity.OrderStoreEntity;
import com.woosung.quick.delivery.entity.StoreMenuEntity;
import com.woosung.quick.delivery.model.command.CreateOrderItemCommand;
import com.woosung.quick.delivery.model.response.CreateOrderItemResponse;
import com.woosung.quick.delivery.payload.request.CreateOrderItemRequest;
import com.woosung.quick.delivery.repository.OrderItemRepository;
import com.woosung.quick.delivery.repository.jpa.OrderStoreJpaRepository;
import com.woosung.quick.delivery.repository.jpa.StoreMenuJpaRepository;
import com.woosung.quick.delivery.service.OrderItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultOrderItemService implements OrderItemService {
    private OrderItemRepository orderItemRepository;

    @Override
    public CreateOrderItemResponse createOrderItem(List<CreateOrderItemCommand> commands) {
        commands.forEach(x -> orderItemRepository.insertOrderItem(x));

        return CreateOrderItemResponse.builder()
                .result(true)
                .build();
    }
}
