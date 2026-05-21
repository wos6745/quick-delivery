package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
