package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.entity.OrderStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStoreRepository  extends JpaRepository<OrderStoreEntity, Long> {
}
