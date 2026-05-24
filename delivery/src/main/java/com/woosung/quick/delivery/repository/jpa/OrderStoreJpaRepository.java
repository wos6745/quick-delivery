package com.woosung.quick.delivery.repository.jpa;

import com.woosung.quick.delivery.entity.OrderStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderStoreJpaRepository extends JpaRepository<OrderStoreEntity, Long> {
    @Query(value = "SELECT NEXT VALUE FOR SEQ_ORDER_STORE_BUSINESS_ID", nativeQuery = true)
    Long getNextOrderStoreSequence();
}
