package com.kipcollo.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Document
public class Customer {
    
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String location;


}
