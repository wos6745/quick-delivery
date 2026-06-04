package com.woosung.quick.delivery.repository.delivery.impl;

import com.woosung.quick.delivery.common.Supports.DeliveryStatus;
import com.woosung.quick.delivery.common.model.command.DeliveryCommand.*;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel.*;
import com.woosung.quick.delivery.entity.DeliveryEntity;
import com.woosung.quick.delivery.entity.OrderEntity;
import com.woosung.quick.delivery.repository.delivery.DeliveryRepository;
import com.woosung.quick.delivery.repository.delivery.jpa.DeliveryJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
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
                .status(DeliveryStatus.CALL_WAITING)
                .build();

        deliveryJpaRepository.save(deliveryEntity);

        return InsertDeliveryResult.builder()
                .deliveryId(deliveryEntity.getDeliveryId())
                .result(true)
                .build();

    }

    @Override
    public AcceptDeliveryResult acceptDelivery(AcceptDeliveryCommand command) {
        DeliveryEntity deliveryEntity = deliveryJpaRepository.findByDeliveryId(command.deliveryId())
                .orElseThrow(EntityNotFoundException::new);
        deliveryEntity.acceptDelivery();

        return AcceptDeliveryResult.builder()
                .result(true)
                .deliveryId(deliveryEntity.getDeliveryId())
                .build();
    }

    @Override
    public PickupDeliveryResult pickDelivery(PickupDeliveryCommand command) {
        DeliveryEntity deliveryEntity = deliveryJpaRepository.findByDeliveryId(command.deliveryId())
                .orElseThrow(EntityNotFoundException::new);
        deliveryEntity.pickUpdelivery();

        return PickupDeliveryResult.builder()
                .result(true)
                .deliveryId(deliveryEntity.getDeliveryId())
                .orderId(deliveryEntity.getOrder().getOrderId())
                .build();
    }
}
