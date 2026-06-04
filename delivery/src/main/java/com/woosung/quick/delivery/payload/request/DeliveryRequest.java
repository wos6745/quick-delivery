package com.woosung.quick.delivery.payload.request;

public class DeliveryRequest {
    public record CallRiderRequest(String deliveryAddress, String riderRequestMessage, Long riderId, Long orderId) {}
}
