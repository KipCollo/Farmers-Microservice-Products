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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    
    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(service.getProductById(id));
    }
    
    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest products) {
        return ResponseEntity.ok(service.createProduct(products));
    }
    
    @PostMapping("/purchase")
    public ResponseEntity<List<PurchasedProductResponse>> purchaseProducts(@RequestBody List<PurchaseProductRequest> purchaseProducts) {
        return ResponseEntity.ok(service.purchaseProduct(purchaseProducts));
    }
    
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Integer>  deleteProduct(@PathVariable Integer id){
        return ResponseEntity.ok(service.deleteProduct(id));
        }
    
    
}
