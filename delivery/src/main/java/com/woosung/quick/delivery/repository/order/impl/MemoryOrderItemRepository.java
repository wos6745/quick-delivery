package com.woosung.quick.delivery.repository.order.impl;

import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderItemCommand;
import com.woosung.quick.delivery.entity.OrderItemEntity;
import com.woosung.quick.delivery.entity.OrderStoreEntity;
import com.woosung.quick.delivery.entity.StoreMenuEntity;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderItemResult;
import com.woosung.quick.delivery.repository.order.OrderItemRepository;
import com.woosung.quick.delivery.repository.order.jpa.OrderItemJpaRepository;
import com.woosung.quick.delivery.repository.order.jpa.OrderStoreJpaRepository;
import com.woosung.quick.delivery.repository.order.jpa.StoreMenuJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
