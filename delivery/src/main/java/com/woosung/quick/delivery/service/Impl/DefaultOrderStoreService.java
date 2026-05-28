package com.woosung.quick.delivery.service.Impl;

import com.woosung.quick.delivery.model.write.OrderWriteModel;
import com.woosung.quick.delivery.model.write.OrderWriteModel.CreateOrderStoreResult;
import com.woosung.quick.delivery.repository.OrderStoreRepository;
import com.woosung.quick.delivery.service.OrderItemService;
import com.woosung.quick.delivery.service.OrderStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.payload.response.OrderResponse.*;

@Service
@RequiredArgsConstructor
public class DefaultOrderStoreService implements OrderStoreService {
    private final OrderItemService orderItemService;
    private final OrderStoreRepository orderStoreRepository;


    @Override
    public CreateOrderStoreResponse createOrderStore(List<CreateOrderStoreCommand> commands) {
        commands.forEach(x -> {
            CreateOrderStoreResult orderStoreRes = orderStoreRepository.insertOrderStore(x);

            List<CreateOrderItemCommand> orderItemCommands = x.orderItemRequests()
                    .stream()
                    .map(y -> CreateOrderItemCommand.of(y, orderStoreRes.id()))
                    .toList();

            CreateOrderItemResponse orderItem = orderItemService.createOrderItem(orderItemCommands);
        });

        return CreateOrderStoreResponse.builder()
                .result(true)
                .build();
    }
}
