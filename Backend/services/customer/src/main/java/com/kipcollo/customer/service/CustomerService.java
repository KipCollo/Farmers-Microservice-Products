package com.kipcollo.customer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kipcollo.customer.dto.CustomerRequest;
import com.kipcollo.customer.dto.CustomerResponse;
import com.kipcollo.customer.exceptions.CustomerNotFoundException;
import com.kipcollo.customer.model.Customer;
import com.kipcollo.customer.repository.CustomerRepository;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private CustomerRepository repo;
    private CustomerMapper mapper;

    public List<CustomerResponse> getAllCustomers() {
         return repo.findAll()
            .stream()
            .map(mapper::fromCustomer)
            .collect(Collectors.toList());
    }

    public Boolean existsById(String customerId) {
        return repo.findById(customerId)
            .isPresent();
    }

    public CustomerResponse getCustomerById(String customerId) {
        return repo.findById(customerId)
            .map(mapper::fromCustomer)
            .orElseThrow(()->new CustomerNotFoundException(
                String.format("Customer not found with provided ID:: %s",customerId)));
    }

    public String addCustomer(CustomerRequest request) {
        Customer customer= repo.save(mapper.toCustomer(request));
        return customer.getCustomerId();
     
    }

    public void updateCustomer(CustomerRequest request) {
        Customer customer= repo.findById(request.getCustomerId()).orElseThrow(
            ()->new CustomerNotFoundException(
                String.format("Cannot update customer:: No customer found with provided id:: %s",request.getCustomerId())
            )
        );
       
        mergeCustomer(customer,request);
        repo.save(customer);
     
    }

    private void mergeCustomer(Customer customer,CustomerRequest request){
        if(StringUtils.isNotBlank(request.getFirstName())){
            customer.setFirstName(request.getFirstName());
        }
        if(StringUtils.isNotBlank(request.getLastName())){
            customer.setLastName(request.getLastName());
        }
        if(StringUtils.isNotBlank(request.getEmail())){
            customer.setEmail(request.getEmail());
        }
        if(StringUtils.isNotBlank(request.getLocation())){
            customer.setLocation(request.getLocation());
        }
      
    }

    public void deleteCustomer(String customerId) {
        repo.deleteById(customerId);

        }


}
