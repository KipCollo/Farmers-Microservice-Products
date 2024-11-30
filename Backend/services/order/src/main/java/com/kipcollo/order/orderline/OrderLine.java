package com.kipcollo.order.orderline;

import com.kipcollo.order.model.Order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

@Entity
public class OrderLine {

    @Id
    @GeneratedValue
    private int orderLineId;
    @ManyToOne
    @JoinColumn(name="orderId")
    private Order order;
    private int productId;
    private double quantity;

}
