package com.woosung.quick.delivery.service.Impl;

import com.woosung.quick.delivery.model.command.CreateOrderItemCommand;
import com.woosung.quick.delivery.model.command.CreateOrderStoreCommand;
import com.woosung.quick.delivery.model.response.CreateOrderItemResponse;
import com.woosung.quick.delivery.model.response.CreateOrderStoreResponse;
import com.woosung.quick.delivery.payload.request.CreateOrderStoreRequest;
import com.woosung.quick.delivery.repository.OrderStoreRepository;
import com.woosung.quick.delivery.service.OrderItemService;
import com.woosung.quick.delivery.service.OrderStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultOrderStoreService implements OrderStoreService {
    private OrderItemService orderItemService;
    private OrderStoreRepository orderStoreRepository;

    @Override
    public CreateOrderStoreResponse createOrderStore(List<CreateOrderStoreCommand> commands) {
        commands.forEach(x -> {
            CreateOrderStoreResponse orderStoreRes = orderStoreRepository.insertOrderStore(x);

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
