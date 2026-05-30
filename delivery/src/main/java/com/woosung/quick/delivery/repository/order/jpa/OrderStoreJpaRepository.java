package com.woosung.quick.delivery.repository.order.jpa;

import com.woosung.quick.delivery.entity.OrderStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderStoreJpaRepository extends JpaRepository<OrderStoreEntity, Long> {
    @Query(value = "SELECT NEXT VALUE FOR SEQ_ORDER_STORE_BUSINESS_ID", nativeQuery = true)
    Long getNextOrderStoreSequence();

    Optional<List<OrderStoreEntity>> findByOrder_OrderId(Long orderId);

}
