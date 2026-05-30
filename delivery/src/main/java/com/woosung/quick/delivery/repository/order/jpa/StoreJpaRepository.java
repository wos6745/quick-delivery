package com.woosung.quick.delivery.repository.order.jpa;

import com.woosung.quick.delivery.entity.OrderStoreEntity;
import com.woosung.quick.delivery.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreJpaRepository extends JpaRepository<StoreEntity, Long> {
}
