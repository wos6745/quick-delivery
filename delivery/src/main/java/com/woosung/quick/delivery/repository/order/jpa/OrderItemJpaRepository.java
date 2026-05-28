package com.woosung.quick.delivery.repository.order.jpa;

import com.woosung.quick.delivery.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {
    @Query(value = "SELECT NEXT VALUE FOR SEQ_ORDER_ITEM_BUSINESS_ID", nativeQuery = true)
    Long getNextOrderItemSequence();
}
