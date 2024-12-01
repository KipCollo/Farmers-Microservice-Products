package com.kipcollo.notifications.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer{

    private String id;
    private String firstName;
    private String lastName;
    private String email;

}
