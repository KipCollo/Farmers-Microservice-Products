package com.kipcollo.ecommerce.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest{

    private int id;

    @NotNull(message="Product name is required")
    private String name;
    
    private String description;

    @Positive(message="Available Quantity should be positive value")
    private double availableQuantity;

    @Positive(message="Price should be positive value")
    private BigDecimal price;

    @NotNull(message="category is required")
    private int categoryId;
}
