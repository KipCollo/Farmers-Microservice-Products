package com.kipcollo.order.orderline;

import org.springframework.stereotype.Service;

import com.kipcollo.order.model.Order;

@Service
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest orderLineRequest){
        return OrderLine.builder()
                .orderLineId(orderLineRequest.getOrderId())
                .quantity(orderLineRequest.getQuantity())
                .order(
                    Order.builder()
                        .orderId(orderLineRequest.getOrderId())
                        .build()
                )
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine){
        return new OrderLineResponse(orderLine.getOrderLineId(),orderLine.getQuantity());
    }
}
