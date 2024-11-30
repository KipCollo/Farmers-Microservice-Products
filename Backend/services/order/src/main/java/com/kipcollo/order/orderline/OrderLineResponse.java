package com.kipcollo.order.orderline;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLineResponse {
    
    private int id;
    private double quantity;

}
