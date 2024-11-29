package com.kipcollo.ecommerce.controller;

import java.util.List;
import java.util.Optional;

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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kipcollo.ecommerce.dto.ProductRequest;
import com.kipcollo.ecommerce.dto.ProductResponse;
import com.kipcollo.ecommerce.dto.PurchaseProductRequest;
import com.kipcollo.ecommerce.dto.PurchasedProductResponse;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity<List<ProductResponse>>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<ProductResponse>> getProductById(@PathVariable int id) {
        return ResponseEntity<Optional<ProductResponse>>(service.getProductById(id),HttpStatus.OK);
    }
    
    @PostMapping("/products")
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest productreq) {
        return ResponseEntity<Integer>(service.createProduct(productreq),HttpStatus.CREATED);
    }
    
    @PostMapping("/purchase")
    public ResponseEntity<PurchasedProductResponse> purchaseProducts(@RequestBody List<PurchaseProductRequest> purchaseReq) {        
        return ResponseEntity.ok(service.purchaseProducts(purchaseReq));
    }
    
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Optional<Integer>>  deleteProduct(@PathVariable ObjectId id){
        return ResponseEntity<Optional<ObjectId>>(ps.deleteProduct(id),HttpStatus.OK);
        }
    
    
}
