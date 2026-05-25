package com.woosung.quick.delivery.entity;


import com.woosung.quick.delivery.entity.base.JpaBaseTimeEntity;
import com.woosung.quick.delivery.global.Supports;
import com.woosung.quick.delivery.model.command.CancelOrderCommand;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.woosung.quick.delivery.global.Supports.*;

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
    private List<OrderStoreEntity> storeList = new ArrayList<>();

    public void cancelOrder(CancelOrderCommand command) {
        this.orderStatus = command.orderStatus();
        this.cancelMessage = command.cancelMessage();
    }
}
