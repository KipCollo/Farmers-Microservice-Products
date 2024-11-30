package com.kipcollo.order.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private String customerId;
    private String firstName;
    private String lastName;
    private String email;

}
