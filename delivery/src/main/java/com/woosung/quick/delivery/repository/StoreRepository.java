package com.woosung.quick.delivery.repository;

import com.woosung.quick.delivery.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
}
