package com.woosung.quick.delivery.service.delivery;

import com.woosung.quick.delivery.payload.request.StoreRequest.CallRiderRequest;
import com.woosung.quick.delivery.payload.response.StoreResponse.CallRiderResponse;

public interface DeliveryService {
    CallRiderResponse callRider(CallRiderRequest req);
}
