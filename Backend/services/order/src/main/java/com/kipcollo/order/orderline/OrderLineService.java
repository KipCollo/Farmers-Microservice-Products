package com.kipcollo.order.orderline;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repo;
    private final OrderLineMapper mapper;

    public int saveOrderLine(OrderLineRequest orderLineRequest){
        OrderLine order =mapper.toOrderLine(orderLineRequest);
        return repo.save(order).getOrderLineId();
    }

    public List<OrderLineResponse> findAllByOrderId(int orderId){
        return repo.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }

}
