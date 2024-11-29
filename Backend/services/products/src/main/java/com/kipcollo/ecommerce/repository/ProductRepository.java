package com.kipcollo.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kipcollo.ecommerce.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

    List<Product> findAllByIdInOrderId(List<Integer> productIds);

}
