package com.woosung.quick.delivery.repository.order.jpa;

import com.woosung.quick.delivery.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {
    @Query(value = "SELECT NEXT VALUE FOR SEQ_ORDER_ITEM_BUSINESS_ID", nativeQuery = true)
    Long getNextOrderItemSequence();

    @Query("SELECT sum(sm.menuPrice) " +
            "from OrderItemEntity oi " +
            "Inner join oi.storeMenu sm " +
            "WHERE oi.orderStore.id in :storeIds")
    Long getOrderItemsTotalPointByStoreIds(List<Long> storeIds);
}
