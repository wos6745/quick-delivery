package com.woosung.quick.delivery.repository.order.jpa.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrderDTO;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrdersDTO;
import com.woosung.quick.delivery.common.model.read.QOrderReadModel_SelectOrderDTO;
import com.woosung.quick.delivery.common.model.read.QOrderReadModel_SelectOrdersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.woosung.quick.delivery.entity.QOrderEntity.orderEntity;
import static com.woosung.quick.delivery.entity.QOrderItemEntity.*;
import static com.woosung.quick.delivery.entity.QOrderStoreEntity.orderStoreEntity;
import static com.woosung.quick.delivery.entity.QStoreEntity.*;
import static com.woosung.quick.delivery.entity.QStoreMenuEntity.*;

@Repository
@RequiredArgsConstructor
public class JpaQueryOrderRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<SelectOrdersDTO> selectOrderByCustomerId(String customerId) {

        return jpaQueryFactory
                .select(new QOrderReadModel_SelectOrdersDTO(
                        orderEntity.orderId,
                        orderEntity.customerId,
                        orderEntity.customerName,
                        orderEntity.customerAddress,
                        orderEntity.customerPhoneNumber,
                        orderEntity.orderStatus,
                        orderEntity.cancelMessage,
                        storeEntity.id,
                        storeEntity.storeName,
                        storeMenuEntity.id,
                        storeMenuEntity.menuName,
                        orderItemEntity.count,
                        storeMenuEntity.menuPrice
                ))
                .from(orderEntity)
                .innerJoin(orderStoreEntity)
                .on(orderEntity.id.eq(orderStoreEntity.order.id))
                .innerJoin(orderItemEntity)
                .on(orderStoreEntity.id.eq(orderItemEntity.orderStore.id))
                .innerJoin(storeEntity)
                .on(storeEntity.id.eq(orderStoreEntity.store.id))
                .innerJoin(storeMenuEntity)
                .on(storeMenuEntity.id.eq(orderItemEntity.storeMenu.id))
                .where(orderEntity.customerId.eq(customerId))
                .fetch();
    }

    public List<SelectOrderDTO> selectOrderByOrderId(Long orderId) {

        return jpaQueryFactory
                .select(new QOrderReadModel_SelectOrderDTO(
                        orderEntity.orderId,
                        orderEntity.customerId,
                        orderEntity.customerName,
                        orderEntity.customerAddress,
                        orderEntity.customerPhoneNumber,
                        orderEntity.orderStatus,
                        orderEntity.cancelMessage,
                        storeEntity.id,
                        storeEntity.storeName,
                        storeMenuEntity.id,
                        storeMenuEntity.menuName,
                        orderItemEntity.count,
                        storeMenuEntity.menuPrice
                ))
                .from(orderEntity)
                .innerJoin(orderStoreEntity)
                .on(orderEntity.id.eq(orderStoreEntity.order.id))
                .innerJoin(orderItemEntity)
                .on(orderStoreEntity.id.eq(orderItemEntity.orderStore.id))
                .innerJoin(storeEntity)
                .on(storeEntity.id.eq(orderStoreEntity.store.id))
                .innerJoin(storeMenuEntity)
                .on(storeMenuEntity.id.eq(orderItemEntity.storeMenu.id))
                .where(orderEntity.orderId.eq(orderId))
                .fetch();
    }
}
