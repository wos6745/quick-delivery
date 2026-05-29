package com.woosung.quick.delivery.entity;

import com.woosung.quick.delivery.common.Supports;
import com.woosung.quick.delivery.common.Supports.ErrorCode;
import com.woosung.quick.delivery.common.exception.NotEnoughBalanceException;
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

    public void deduct(Long point) {
        if (this.pointBalance < point) {
            throw new NotEnoughBalanceException(ErrorCode.NOT_ENOUGH_BALANCE);
        }

        this.pointBalance -= point;
    }
}
