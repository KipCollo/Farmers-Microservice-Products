package com.kipcollo.ecommerce.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseProductRequest {
    
    @NotNull(message="Product id is required")
    private int productId;

    @NotNull(message="Quantity is required")
    private double quantity;

}
