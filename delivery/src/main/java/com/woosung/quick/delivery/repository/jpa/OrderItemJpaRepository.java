package com.woosung.quick.delivery.repository.jpa;

import com.woosung.quick.delivery.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {
}
