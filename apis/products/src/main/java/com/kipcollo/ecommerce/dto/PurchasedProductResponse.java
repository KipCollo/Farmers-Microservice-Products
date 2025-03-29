package com.kipcollo.ecommerce.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PurchasedProductResponse {

    private int productId;
    private String name;
    private String description;
    private BigDecimal price;
    private double quantity;
}
