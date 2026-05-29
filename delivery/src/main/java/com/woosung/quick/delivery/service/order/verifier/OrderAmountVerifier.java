package com.woosung.quick.delivery.service.order.verifier;

import com.woosung.quick.delivery.entity.StoreMenuEntity;
import com.woosung.quick.delivery.payload.request.OrderRequest;
import com.woosung.quick.delivery.payload.request.OrderRequest.ValidateTotalPointRequest;
import com.woosung.quick.delivery.payload.response.OrderResponse;
import com.woosung.quick.delivery.payload.response.OrderResponse.ValidateTotalPointResponse;
import com.woosung.quick.delivery.repository.order.jpa.StoreMenuJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OrderAmountVerifier {
    private final StoreMenuJpaRepository storeMenuJpaRepository;

    @Transactional(readOnly = true)
    public ValidateTotalPointResponse validateTotalPoint(ValidateTotalPointRequest request) {
        long calculatedTotalPoint = request.list().stream()
                .mapToLong(this::calculateItemTotalPoint)
                .sum();

        Long inputTotalPoint = request.totalPoints();
        boolean matched = inputTotalPoint != null && calculatedTotalPoint == inputTotalPoint;

        return ValidateTotalPointResponse.builder()
                .result(matched)
                .outputTotalPoints(calculatedTotalPoint)
                .inputTotalPoints(inputTotalPoint)
                .build();
    }

    private long calculateItemTotalPoint(OrderRequest.CreateOrderItemRequest item) {
        StoreMenuEntity storeMenu = storeMenuJpaRepository.findById(item.storeMenuId())
                .orElseThrow(EntityNotFoundException::new);

        return storeMenu.getMenuPrice() * item.count();
    }
}
