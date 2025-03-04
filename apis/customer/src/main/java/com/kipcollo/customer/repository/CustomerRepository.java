package com.kipcollo.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kipcollo.customer.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{

}
