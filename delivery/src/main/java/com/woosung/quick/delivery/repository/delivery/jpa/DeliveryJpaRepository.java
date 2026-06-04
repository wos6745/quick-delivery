package com.woosung.quick.delivery.repository.delivery.jpa;

import com.woosung.quick.delivery.common.Supports.OrderStatus;
import com.woosung.quick.delivery.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface DeliveryJpaRepository extends JpaRepository<DeliveryEntity, Long> {
    Optional<DeliveryEntity> findByDeliveryId(Long deliveryId);
}
