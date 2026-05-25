package com.woosung.quick.delivery.service.Impl;

import com.woosung.quick.delivery.model.command.OrderCommand;
import com.woosung.quick.delivery.repository.OrderItemRepository;
import com.woosung.quick.delivery.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.woosung.quick.delivery.model.command.OrderCommand.*;
import static com.woosung.quick.delivery.model.response.OrderResponse.*;

@Service
@RequiredArgsConstructor
public class DefaultOrderItemService implements OrderItemService {
    private OrderItemRepository orderItemRepository;

    @Override
    public CreateOrderItemResponse createOrderItem(List<CreateOrderItemCommand> commands) {
        commands.forEach(x -> orderItemRepository.insertOrderItem(x));

        return CreateOrderItemResponse.builder()
                .result(true)
                .build();
    }
}
