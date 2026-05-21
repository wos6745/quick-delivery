package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
