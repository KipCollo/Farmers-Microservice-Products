package com.kipcollo.customer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kipcollo.customer.dto.CustomerRequest;
import com.kipcollo.customer.dto.CustomerResponse;
import com.kipcollo.customer.service.CustomerService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String customerId){
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }

    @GetMapping("exists/{customerId}")
    public ResponseEntity<Boolean> existsById(@PathVariable String customerId){
        return ResponseEntity.ok(service.existsById(customerId));
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(service.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest request){
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }
    
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId){
        service.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
        
    }
}
