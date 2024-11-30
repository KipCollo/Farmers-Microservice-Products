package com.kipcollo.order.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequest {
    @NotNull(message="Product is mandatory")
    private int productId;

    @Positive(message = "Quanity is mandatory")
    private double quantity;

}
