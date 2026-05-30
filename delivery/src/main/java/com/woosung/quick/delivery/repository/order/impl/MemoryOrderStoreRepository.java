package com.woosung.quick.delivery.repository.order.impl;

import com.woosung.quick.delivery.common.model.command.OrderCommand.CreateOrderStoreCommand;
import com.woosung.quick.delivery.common.model.query.OrderQuery;
import com.woosung.quick.delivery.common.model.query.OrderQuery.SelectOrderStoresQuery;
import com.woosung.quick.delivery.common.model.read.OrderReadModel;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrderStoresResult;
import com.woosung.quick.delivery.entity.OrderEntity;
import com.woosung.quick.delivery.entity.OrderStoreEntity;
import com.woosung.quick.delivery.entity.StoreEntity;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderStoreResult;
import com.woosung.quick.delivery.repository.order.OrderStoreRepository;
import com.woosung.quick.delivery.repository.order.jpa.OrderJpaRepository;
import com.woosung.quick.delivery.repository.order.jpa.OrderStoreJpaRepository;
import com.woosung.quick.delivery.repository.order.jpa.StoreJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemoryOrderStoreRepository implements OrderStoreRepository {
    private final OrderStoreJpaRepository orderStoreJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    private final StoreJpaRepository storeJpaRepository;

    @Override
    public CreateOrderStoreResult insertOrderStore(CreateOrderStoreCommand command) {
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

        return CreateOrderStoreResult.builder()
                .id(result.getId())
                .result(true)
                .build();
    }

    @Override
    public SelectOrderStoresResult selectOrderStores(SelectOrderStoresQuery query) {
        List<OrderStoreEntity> orderStoreEntities = orderStoreJpaRepository.findByOrder_OrderId(query.orderId())
                .orElseThrow(EntityNotFoundException::new);
        
        List<Long> orderStoreIds = orderStoreEntities.stream()
                .map(OrderStoreEntity::getOrderStoreId)
                .toList();

        return SelectOrderStoresResult
                .builder()
                .orderStoreIds(orderStoreIds)
                .build();
    }
}
