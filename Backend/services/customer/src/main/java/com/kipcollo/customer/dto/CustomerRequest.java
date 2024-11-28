package com.kipcollo.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest{
   
    private String customerId;

    @NotNull(message="Customer first name is required")
    private String firstName;

    @NotNull(message="Customer last name is required")
    private String lastName;

    @Email(message="Enter a valid email")
    @NotNull(message="Email is required")
    private String email;

    @NotNull(message="Location is required")
    private String location;

    
}
