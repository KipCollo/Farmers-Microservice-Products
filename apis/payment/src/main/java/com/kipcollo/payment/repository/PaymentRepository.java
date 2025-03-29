package com.kipcollo.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kipcollo.payment.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}
