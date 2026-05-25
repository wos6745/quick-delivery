package com.woosung.quick.delivery.repository.Impl;

import com.woosung.quick.delivery.entity.OrderEntity;
import com.woosung.quick.delivery.global.Supports;
import com.woosung.quick.delivery.model.command.CancelOrderCommand;
import com.woosung.quick.delivery.model.command.CreateOrderCommand;
import com.woosung.quick.delivery.model.response.CancelOrderResponse;
import com.woosung.quick.delivery.model.response.CreateOrderResponse;
import com.woosung.quick.delivery.repository.OrderRepository;
import com.woosung.quick.delivery.repository.jpa.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.woosung.quick.delivery.global.Supports.*;

@Repository
@RequiredArgsConstructor
public class MemoryOrderRepository implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public CreateOrderResponse insertOrder(CreateOrderCommand command) {
        OrderEntity entity = OrderEntity.builder()
                .orderStatus(OrderStatus.PENDING)
                .orderId(orderJpaRepository.getNextOrderSequence().toString())
                .customerAddress(command.customerAddress())
                .customerName(command.customerName())
                .customerId(command.customerId())
                .customerPhoneNumber(command.customerPhoneNumber())
                .build();

        orderJpaRepository.save(entity);

        return CreateOrderResponse.builder()
                .id(entity.getId())
                .result(true)
                .build();
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderCommand command) {
        OrderEntity orderEntity = orderJpaRepository.getOrderEntityByOrderId(command.orderId());
        orderEntity.cancelOrder(command);

        return CancelOrderResponse.builder()
                .result(true)
                .build();
    }
}
