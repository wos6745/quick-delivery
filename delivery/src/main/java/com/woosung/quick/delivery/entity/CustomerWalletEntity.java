package com.woosung.quick.delivery.entity;

import com.woosung.quick.delivery.entity.base.JpaBaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "CustomerWallet")
@Getter
@SuperBuilder
public class CustomerWalletEntity extends JpaBaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String customerId;

    private Long pointBalance;

    @Version
    private Integer version;
}
