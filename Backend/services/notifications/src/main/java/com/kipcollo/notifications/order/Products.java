package com.kipcollo.notifications.order;

import java.math.BigDecimal;

public record Products (

    String id,
    String productName,
    String description,
    BigDecimal price,
    double quantity

){

}
