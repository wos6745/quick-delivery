package com.woosung.quick.delivery.repository.jpa;

import com.woosung.quick.delivery.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}
