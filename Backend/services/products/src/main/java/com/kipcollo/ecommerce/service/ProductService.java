package com.kipcollo.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kipcollo.ecommerce.model.Product;
import com.kipcollo.ecommerce.repository.repository;



@Service
public class ProductService {


    @Autowired
    private repository repo;


    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Optional<Product> getProductById(ObjectId id) {
        return repo.findById(id);
    }

    public ObjectId createNewProduct(Product productreq) {
        repo.save(productreq);
       return productreq.getId();
    }

    public Optional<ObjectId> deleteProduct(ObjectId id) {
         repo.deleteById(id);
        return Optional.of(id);
        
    }

}
