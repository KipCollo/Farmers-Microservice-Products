package com.kipcollo.payment.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    
    private String customerId;
    @NotNull(message="First name is required")
    private String firstName;
    @NotNull(message="last name is required")
    private String lastName;
    @NotNull(message="Email is required")
    @Email(message="Invalid email")
    private String email;


}
