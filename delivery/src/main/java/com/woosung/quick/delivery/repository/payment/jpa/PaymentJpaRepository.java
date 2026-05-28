package com.woosung.quick.delivery.repository.payment.jpa;

import com.woosung.quick.delivery.entity.CustomerWalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<CustomerWalletEntity, Long> {
    CustomerWalletEntity getCustomerWalletEntityByCustomerId(String customerId);
}
