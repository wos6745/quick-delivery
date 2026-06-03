package com.woosung.quick.delivery.entity;

import com.woosung.quick.delivery.entity.base.JpaBaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Delivery")
@Getter
@SuperBuilder
public class DeliveryEntity extends JpaBaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long deliveryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private OrderEntity order;

    private String deliveryAddress;
    private String riderRequestMessage;

    private Long riderId;
}
