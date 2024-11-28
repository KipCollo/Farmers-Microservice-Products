package com.kipcollo.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse{
   
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String location;

    
}