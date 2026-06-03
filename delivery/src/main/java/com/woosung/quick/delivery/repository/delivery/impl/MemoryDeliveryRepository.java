package com.woosung.quick.delivery.repository.delivery.impl;

import com.woosung.quick.delivery.common.model.command.DeliveryCommand.InsertDeliveryCommand;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel.InsertDeliveryResult;
import com.woosung.quick.delivery.entity.DeliveryEntity;
import com.woosung.quick.delivery.entity.OrderEntity;
import com.woosung.quick.delivery.repository.delivery.DeliveryRepository;
import com.woosung.quick.delivery.repository.delivery.jpa.DeliveryJpaRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemoryDeliveryRepository implements DeliveryRepository {
    private final DeliveryJpaRepository deliveryJpaRepository;
    private final EntityManager em;

    @Override
    public InsertDeliveryResult insertDelivery(InsertDeliveryCommand command) {
        OrderEntity orderProxy = em.getReference(OrderEntity.class, command.orderId());

        DeliveryEntity deliveryEntity = DeliveryEntity.builder()
                .order(orderProxy)
                .deliveryAddress(command.deliveryAddress())
                .riderId(command.riderId())
                .riderRequestMessage(command.riderRequestMessage())
                .build();

        DeliveryEntity result = deliveryJpaRepository.save(deliveryEntity);

        return InsertDeliveryResult.builder()
                .deliveryId(deliveryEntity.getDeliveryId())
                .result(true)
                .build();

    }
}
