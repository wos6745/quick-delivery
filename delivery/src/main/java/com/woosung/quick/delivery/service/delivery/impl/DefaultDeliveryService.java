package com.woosung.quick.delivery.service.delivery.impl;

import com.woosung.quick.delivery.common.model.command.DeliveryCommand;
import com.woosung.quick.delivery.common.model.command.DeliveryCommand.AcceptDeliveryCommand;
import com.woosung.quick.delivery.common.model.command.DeliveryCommand.InsertDeliveryCommand;
import com.woosung.quick.delivery.common.model.command.DeliveryCommand.PickupDeliveryCommand;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel.AcceptDeliveryResult;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel.InsertDeliveryResult;
import com.woosung.quick.delivery.common.model.write.DeliveryWriteModel.PickupDeliveryResult;
import com.woosung.quick.delivery.payload.request.DeliveryRequest.CallRiderRequest;
import com.woosung.quick.delivery.payload.response.DeliveryResponse;
import com.woosung.quick.delivery.payload.response.DeliveryResponse.AcceptDeliveryResponse;
import com.woosung.quick.delivery.payload.response.DeliveryResponse.CallRiderResponse;
import com.woosung.quick.delivery.payload.response.DeliveryResponse.PickUpDeliveryResponse;
import com.woosung.quick.delivery.repository.delivery.DeliveryRepository;
import com.woosung.quick.delivery.service.delivery.DeliveryService;
import com.woosung.quick.delivery.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultDeliveryService implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final OrderService orderService;

    @Override
    public CallRiderResponse callRider(CallRiderRequest req) {
        InsertDeliveryCommand insertDeliveryCommand = InsertDeliveryCommand.of(req);

        InsertDeliveryResult insertDeliveryResult = deliveryRepository.insertDelivery(insertDeliveryCommand);
        return CallRiderResponse.builder()
                .deliveryId(insertDeliveryResult.deliveryId())
                .build();
    }

    @Override
    @Transactional
    public AcceptDeliveryResponse acceptDelivery(Long deliveryId) {
        AcceptDeliveryCommand acceptDeliveryCommand = AcceptDeliveryCommand.builder()
                .deliveryId(deliveryId)
                .build();

        AcceptDeliveryResult acceptDeliveryResult = deliveryRepository.acceptDelivery(acceptDeliveryCommand);

        return AcceptDeliveryResponse.builder()
                .deliveryId(acceptDeliveryResult.deliveryId())
                .build();
    }

    @Override
    public PickUpDeliveryResponse pickUpDelivery(Long deliveryId) {
        PickupDeliveryCommand pickupDeliveryCommand = PickupDeliveryCommand.builder()
                .deliveryId(deliveryId)
                .build();

        PickupDeliveryResult pickupDeliveryResult = deliveryRepository.pickDelivery(pickupDeliveryCommand);



        return null;
    }
}
