package com.kipcollo.ecommerce.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kipcollo.ecommerce.model.Product;


@Repository
public interface repository extends MongoRepository<Product,ObjectId>{

}
