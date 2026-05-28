package com.woosung.quick.delivery.repository.Impl;

import com.woosung.quick.delivery.entity.OrderEntity;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrderDTO;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrderResult;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrdersDTO;
import com.woosung.quick.delivery.common.model.read.OrderReadModel.SelectOrdersResult;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CancelOrderResult;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.CreateOrderResult;
import com.woosung.quick.delivery.repository.OrderRepository;
import com.woosung.quick.delivery.repository.jpa.OrderJpaRepository;
import com.woosung.quick.delivery.repository.jpa.querydsl.JpaQueryOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.woosung.quick.delivery.common.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.common.model.query.OrderQuery.*;
import static com.woosung.quick.delivery.common.Supports.*;

@Repository
@RequiredArgsConstructor
public class MemoryOrderRepository implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;
    private final JpaQueryOrderRepository jpaQueryOrderRepository;

    @Override
    public SelectOrdersResult selectOrders(SelectOrdersQuery query) {
        List<SelectOrdersDTO> result = jpaQueryOrderRepository.selectOrderByCustomerId(query.customerId());

        return SelectOrdersResult.builder()
                .orders(result)
                .build();
    }

    @Override
    public SelectOrderResult selectOrder(SelectOrderQuery query) {
        List<SelectOrderDTO> result = jpaQueryOrderRepository.selectOrderByOrderId(query.orderId());

        return SelectOrderResult.builder().
                order(result).
                build();
    }

    @Override
    public CreateOrderResult insertOrder(CreateOrderCommand command) {
        OrderEntity entity = OrderEntity.builder()
                .orderStatus(OrderStatus.PENDING)
                .orderId(orderJpaRepository.getNextOrderSequence().toString())
                .customerAddress(command.customerAddress())
                .customerName(command.customerName())
                .customerId(command.customerId())
                .customerPhoneNumber(command.customerPhoneNumber())
                .build();

        orderJpaRepository.save(entity);

        return CreateOrderResult.builder()
                .id(entity.getId())
                .result(true)
                .build();
    }

    @Override
    public CancelOrderResult cancelOrder(CancelOrderCommand command) {
        OrderEntity orderEntity = orderJpaRepository.getOrderEntityByOrderId(command.orderId());
        orderEntity.cancelOrder(command);

        return CancelOrderResult.builder()
                .result(true)
                .build();
    }
}
