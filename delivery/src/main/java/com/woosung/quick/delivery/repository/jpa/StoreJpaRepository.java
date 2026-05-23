package com.woosung.quick.delivery.repository.jpa;

import com.woosung.quick.delivery.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreJpaRepository extends JpaRepository<StoreEntity, Long> {
}
