package com.kipcollo.order.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PurchaseResponse {

    private int productId;
    private String name;
    private String description;
    private BigDecimal price;
    private double quantity;


}
