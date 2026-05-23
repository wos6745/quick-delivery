package com.woosung.quick.delivery.repository.jpa;

import com.woosung.quick.delivery.entity.OrderStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStoreJpaRepository extends JpaRepository<OrderStoreEntity, Long> {
}
