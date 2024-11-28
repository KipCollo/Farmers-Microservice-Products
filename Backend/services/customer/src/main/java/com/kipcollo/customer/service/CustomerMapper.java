package com.kipcollo.customer.service;

import org.springframework.stereotype.Service;

import com.kipcollo.customer.dto.CustomerRequest;
import com.kipcollo.customer.dto.CustomerResponse;
import com.kipcollo.customer.model.Customer;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request){
        if(request==null){
            return null;
        }
        
        return Customer.builder()
            .customerId(request.getCustomerId())
            .firstName(request.getFirstName())
            .lastName(request.getLastName)
            .email(request.getEmail())
            .location(request.getLocation())
           .build();
    }

    public CustomerResponse fromCustomer(Customer customer){
        return new CustomerResponse(
            customer.getCustomerId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail(),
            customer.getLocation()
        );
    }
}
