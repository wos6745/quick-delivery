package com.woosung.quick.delivery.service.order;


import com.woosung.quick.delivery.common.model.write.OrderWriteModel;
import com.woosung.quick.delivery.common.model.write.OrderWriteModel.DeliveringOrderResult;

import static com.woosung.quick.delivery.payload.response.OrderResponse.*;
import static com.woosung.quick.delivery.payload.request.OrderRequest.*;

public interface OrderService {
    GetOrdersResponse getOrders(String customerId);
    GetOrderResponse getOrder(Long orderId);
    CreateOrderResponse createOrder(CreateOrderRequest req);
    CancelOrderResponse cancelOrder(CancelOrderRequest req, Long orderId);
    AcceptOrderResponse acceptOrder(AcceptOrderRequest req, Long orderId);
    DeliveringOrderResult deliveringOrder(Long orderId);
}
