package com.woosung.quick.delivery.service.Impl;

import com.woosung.quick.delivery.model.command.CancelOrderCommand;
import com.woosung.quick.delivery.model.command.CreateOrderCommand;
import com.woosung.quick.delivery.model.command.CreateOrderStoreCommand;
import com.woosung.quick.delivery.model.response.CancelOrderResponse;
import com.woosung.quick.delivery.model.response.CreateOrderResponse;
import com.woosung.quick.delivery.payload.request.CancelOrderRequest;
import com.woosung.quick.delivery.payload.request.CreateOrderRequest;
import com.woosung.quick.delivery.repository.OrderItemRepository;
import com.woosung.quick.delivery.repository.OrderRepository;
import com.woosung.quick.delivery.service.OrderItemService;
import com.woosung.quick.delivery.service.OrderService;
import com.woosung.quick.delivery.service.OrderStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
    private final OrderStoreService orderStoreService;
    private final OrderRepository orderRepository;

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest req) {
        CreateOrderCommand orderCommand = CreateOrderCommand.of(req);
        CreateOrderResponse orderRes = orderRepository.insertOrder(orderCommand);

        List<CreateOrderStoreCommand> createOrderStoreCommands = req.orders().
                stream().
                map(x -> CreateOrderStoreCommand.of(x, orderRes.id()))
                .toList();

        orderStoreService.createOrderStore(createOrderStoreCommands);

        return CreateOrderResponse.builder()
                .result(true)
                .build();
    }

    @Override
    public CancelOrderResponse cancelOrderByStore(CancelOrderCommand command) {
        return orderRepository.cancelOrder(command);
    }

    @Override
    public CancelOrderResponse cancelOrderByCustomer(CancelOrderRequest req) {
        CancelOrderCommand command = CancelOrderCommand.of(req);
        return orderRepository.cancelOrder(command);
    }
}