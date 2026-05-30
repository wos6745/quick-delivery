package com.woosung.quick.delivery.repository.payment.jpa;

import com.woosung.quick.delivery.entity.CustomerWalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentJpaRepository extends JpaRepository<CustomerWalletEntity, Long> {
    Optional<CustomerWalletEntity> findByCustomerId(String customerId);
}
