package com.woosung.quick.delivery.repository.delivery.jpa;

import com.woosung.quick.delivery.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryJpaRepository extends JpaRepository<DeliveryEntity, Long> {
}
