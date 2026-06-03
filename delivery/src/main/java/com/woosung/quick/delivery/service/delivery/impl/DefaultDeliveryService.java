package com.woosung.quick.delivery.service.delivery.impl;

import com.woosung.quick.delivery.common.model.command.DeliveryCommand.InsertDeliveryCommand;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel.InsertDeliveryResult;
import com.woosung.quick.delivery.payload.request.StoreRequest.CallRiderRequest;
import com.woosung.quick.delivery.payload.response.StoreResponse.CallRiderResponse;
import com.woosung.quick.delivery.repository.delivery.DeliveryRepository;
import com.woosung.quick.delivery.service.delivery.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultDeliveryService implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    @Override
    public CallRiderResponse callRider(CallRiderRequest req) {
        InsertDeliveryCommand insertDeliveryCommand = InsertDeliveryCommand.of(req);

        InsertDeliveryResult insertDeliveryResult = deliveryRepository.insertDelivery(insertDeliveryCommand);
        return CallRiderResponse.builder()
                .deliveryId(insertDeliveryResult.deliveryId())
                .build();
    }
}
