package com.woosung.quick.delivery.repository.jpa;

import com.woosung.quick.delivery.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
    @Query(value = "SELECT NEXT VALUE FOR SEQ_ORDER_BUSINESS_ID", nativeQuery = true)
    Long getNextOrderSequence();
}
