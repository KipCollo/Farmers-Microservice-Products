package com.kipcollo.registration;

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

public int addCustomer(RequestBody requestBody) {
   Customer cust= repo.save(Customer
    .builder()
    .firstName("collo")
    .email("collo")
    .lastName("kosgei")
    .address(null)
    .build());

    return cust.getCustomerId();
}

// public int deleteCustomer(int CustomerId) {
//     repo.deleteById(CustomerId);
//     return cust.id
// }

}
