package com.kipcollo.order.orderline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineResponse {
    
    private int id;
    private double quantity;

}
