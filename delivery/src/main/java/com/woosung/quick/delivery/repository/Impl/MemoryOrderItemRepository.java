package com.woosung.quick.delivery.repository.Impl;

import com.woosung.quick.delivery.entity.OrderItemEntity;
import com.woosung.quick.delivery.entity.OrderStoreEntity;
import com.woosung.quick.delivery.entity.StoreMenuEntity;
import com.woosung.quick.delivery.model.write.OrderWriteModel;
import com.woosung.quick.delivery.model.write.OrderWriteModel.CreateOrderItemResult;
import com.woosung.quick.delivery.repository.OrderItemRepository;
import com.woosung.quick.delivery.repository.jpa.OrderItemJpaRepository;
import com.woosung.quick.delivery.repository.jpa.OrderStoreJpaRepository;
import com.woosung.quick.delivery.repository.jpa.StoreMenuJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.payload.response.OrderResponse.*;

@Repository
@RequiredArgsConstructor
public class MemoryOrderItemRepository implements OrderItemRepository {
    private final OrderItemJpaRepository orderItemJpaRepository;
    private final OrderStoreJpaRepository orderStoreJpaRepository;
    private final StoreMenuJpaRepository storeMenuJpaRepository;

    @Override
    public CreateOrderItemResult insertOrderItem(CreateOrderItemCommand command) {
        Long orderItemId = orderItemJpaRepository.getNextOrderItemSequence();
        OrderStoreEntity orderStoreEntity = orderStoreJpaRepository.findById(command.orderStoreId())
                .orElseThrow(EntityNotFoundException::new);
        StoreMenuEntity storeMenuEntity = storeMenuJpaRepository.findById(command.storeMenuId())
                .orElseThrow(EntityNotFoundException::new);


        OrderItemEntity orderItemEntity = OrderItemEntity.builder()
                .orderItemId(orderItemId)
                .count(command.count())
                .orderStore(orderStoreEntity)
                .storeMenu(storeMenuEntity)
                .build();


        OrderItemEntity result = orderItemJpaRepository.save(orderItemEntity);

        return CreateOrderItemResult.builder()
                .id(result.getId())
                .result(true)
                .build();
    }
}
