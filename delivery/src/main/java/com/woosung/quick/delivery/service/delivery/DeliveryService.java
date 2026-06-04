package com.woosung.quick.delivery.service.delivery;

import com.woosung.quick.delivery.payload.request.DeliveryRequest.CallRiderRequest;
import com.woosung.quick.delivery.payload.response.DeliveryResponse.*;

public interface DeliveryService {
    CallRiderResponse callRider(CallRiderRequest req);
    AcceptDeliveryResponse acceptDelivery(Long deliveryId);
    PickUpDeliveryResponse pickUpDelivery(Long deliveryId);
}
