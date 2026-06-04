package com.woosung.quick.delivery.common.model.command;

import com.woosung.quick.delivery.common.Supports;
import com.woosung.quick.delivery.common.Supports.DeliveryStatus;
import com.woosung.quick.delivery.payload.request.DeliveryRequest.CallRiderRequest;
import lombok.Builder;

public class DeliveryCommand {
    @Builder
    public record InsertDeliveryCommand(String deliveryAddress, String riderRequestMessage, Long riderId, Long orderId) {
        public static InsertDeliveryCommand of(CallRiderRequest req){
            return InsertDeliveryCommand.builder()
                    .deliveryAddress(req.deliveryAddress())
                    .orderId(req.orderId())
                    .riderRequestMessage(req.riderRequestMessage())
                    .riderId(req.riderId())
                    .build();
        }
    }

    @Builder
    public record AcceptDeliveryCommand(Long deliveryId) {}
    @Builder
    public record PickupDeliveryCommand(Long deliveryId) {}
}
