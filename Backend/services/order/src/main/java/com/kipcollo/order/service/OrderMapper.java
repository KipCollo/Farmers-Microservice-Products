package com.kipcollo.order.service;

import org.springframework.stereotype.Service;

import com.kipcollo.order.dto.OrderRequest;
import com.kipcollo.order.dto.OrderResponse;
import com.kipcollo.order.model.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderMapper{

    public Order toOrder(OrderRequest request){
        return Order.builder()
            .orderId(request.getOrderId())
            .customerId(request.getCustomerId())
            .reference(request.getReference())
            .totalAmount(request.getTotalAmount())
            .paymentMethod(request.getPaymentMethod())
            .build();
    }

    public OrderResponse fromOrder(Order order){
        return new OrderResponse(
            order.getOrderId(),
            order.getReference(),
            order.getTotalAmount(),
            order.getPaymentMethod(),
            order.getCustomerId()
        );
    }
}
