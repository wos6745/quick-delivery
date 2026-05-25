package com.woosung.quick.delivery.repository.Impl;

import com.woosung.quick.delivery.entity.OrderEntity;
import com.woosung.quick.delivery.entity.OrderStoreEntity;
import com.woosung.quick.delivery.entity.StoreEntity;
import com.woosung.quick.delivery.model.command.OrderCommand;
import com.woosung.quick.delivery.repository.OrderStoreRepository;
import com.woosung.quick.delivery.repository.jpa.OrderJpaRepository;
import com.woosung.quick.delivery.repository.jpa.OrderStoreJpaRepository;
import com.woosung.quick.delivery.repository.jpa.StoreJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.model.response.OrderResponse.*;

@Repository
@RequiredArgsConstructor
public class MemoryOrderStoreRepository implements OrderStoreRepository {
    private final OrderStoreJpaRepository orderStoreJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    private final StoreJpaRepository storeJpaRepository;

    @Override
    public CreateOrderStoreResponse insertOrderStore(CreateOrderStoreCommand command) {
        Long orderStoreId = orderStoreJpaRepository.getNextOrderStoreSequence();
        StoreEntity storeEntity = storeJpaRepository.findById(command.storeId())
                .orElseThrow(EntityNotFoundException::new);
        OrderEntity orderEntity = orderJpaRepository.findById(command.orderId())
                .orElseThrow(EntityNotFoundException::new);

        OrderStoreEntity orderStoreEntity = OrderStoreEntity.builder()
                .orderStoreId(orderStoreId)
                .store(storeEntity)
                .order(orderEntity)
                .build();

        OrderStoreEntity result = orderStoreJpaRepository.save(orderStoreEntity);

        return CreateOrderStoreResponse.builder()
                .id(result.getId())
                .result(true)
                .build();
    }

}
