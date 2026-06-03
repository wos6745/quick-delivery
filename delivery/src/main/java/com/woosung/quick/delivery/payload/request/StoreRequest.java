package com.woosung.quick.delivery.payload.request;

public class StoreRequest {
    public record CallRiderRequest(String deliveryAddress, String riderRequestMessage, Long riderId, Long orderId) {}
}
