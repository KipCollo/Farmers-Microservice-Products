package com.kipcollo.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.kipcollo.order.model.PaymentMethod;
import com.kipcollo.order.orderline.OrderLine;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private int orderId;
    private String reference;
    @Positive(message="Amount should be positive")
    private BigDecimal totalAmount;
    @NotNull(message="Payment method should be precise")
    private PaymentMethod paymentMethod;
    @NotNull(message = "Customer should be present")
    @NotBlank(message="Customer should be present")
    private String customerId;
    @NotEmpty(message="You shoud purchase atleast one product")
    private List<PurchaseRequest> products;

}
