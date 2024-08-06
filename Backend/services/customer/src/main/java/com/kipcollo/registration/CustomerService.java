package com.kipcollo.registration;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

   private CustomerRepository repo;

public List<Customer> getAllCustomers() {
    return repo.findAll();
}

public Customer getCustomerById(int customerId) {
    return repo.findById(customerId).orElseThrow();
}

public void addCustomer(RequestBody requestBody) {
    repo.save(requestBody);
}

}
