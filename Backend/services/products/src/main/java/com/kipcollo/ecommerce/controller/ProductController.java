package com.kipcollo.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kipcollo.ecommerce.model.Product;
import com.kipcollo.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    ProductService ps;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(ps.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable ObjectId id) {
        return new  ResponseEntity<Optional<Product>>(ps.getProductById(id),HttpStatus.OK);
    }
    

    @PostMapping("/products")
    public ResponseEntity<ObjectId> createProduct(@RequestBody Product productreq) {
        return new ResponseEntity<ObjectId>(ps.createNewProduct(productreq),HttpStatus.CREATED);
    }
    
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Optional<ObjectId>>  deleteProduct(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<ObjectId>>(ps.deleteProduct(id),HttpStatus.OK);
        }
    
    
}
