package com.kipcollo.ecommerce.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {

    private int id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    private int categoryId;
    private String categoryName;
    private String categoryDescription;

}
