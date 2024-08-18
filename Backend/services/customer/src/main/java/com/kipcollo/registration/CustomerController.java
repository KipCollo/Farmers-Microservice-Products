package com.kipcollo.registration;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId){
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }

    @PostMapping
    public ResponseEntity<Integer> addCustomer(@RequestBody RequestBody requestBody){
        return ResponseEntity.ok(service.addCustomer(requestBody));
    }

    // @DeleteMapping("/{customerId}")
    // public ResponseEntity<Integer> deleteCustomer(@PathVariable int customerId){
    //     return ResponseEntity.ok(service.deleteCustomer());
    // }
}
