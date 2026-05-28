package com.woosung.quick.delivery.entity;


import com.woosung.quick.delivery.common.model.command.OrderCommand.CancelOrderCommand;
import com.woosung.quick.delivery.entity.base.JpaBaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.woosung.quick.delivery.common.Supports.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Order")
@Getter
@SuperBuilder
public class OrderEntity extends JpaBaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String orderId;
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private OrderStatus orderStatus;
    private String cancelMessage;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @Builder.Default
    private List<OrderStoreEntity> storeList = new ArrayList<>();

    public void cancelOrder(CancelOrderCommand command) {
        this.orderStatus = command.orderStatus();
        this.cancelMessage = command.cancelMessage();
    }
}
