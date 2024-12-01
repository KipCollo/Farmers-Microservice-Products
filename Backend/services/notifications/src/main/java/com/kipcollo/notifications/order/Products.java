package com.kipcollo.notifications.order;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    private String id;
    private String productName;
    private String description;
    private BigDecimal price;
    private double quantity;

}
