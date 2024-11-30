package com.kipcollo.order.orderline;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLineRequest {

    private int orderLineId;
    private int orderId;
    private int productId;
    private double quantity;

}
