package com.kipcollo.ecommerce.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kipcollo.ecommerce.dto.ProductRequest;
import com.kipcollo.ecommerce.dto.ProductResponse;
import com.kipcollo.ecommerce.dto.PurchaseProductRequest;
import com.kipcollo.ecommerce.dto.PurchasedProductResponse;
import com.kipcollo.ecommerce.exceptions.ProductNotFoundException;
import com.kipcollo.ecommerce.exceptions.ProductPurchaseException;
import com.kipcollo.ecommerce.model.Product;
import com.kipcollo.ecommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {


    @Autowired
    private ProductRepository repo;
    private ProductMapper mapper;

    public List<ProductResponse> getAllProducts(){
        return repo.findAll()
           .stream()
            .map(mapper::toProductResponse)
            .collect(Collectors.toList());
    }


    
    public ProductResponse getProductById(int id) {
        return repo.findById(id)
            .map(mapper::toProductResponse)
            .orElseThrow(()-> new ProductNotFoundException("Product not found with provided ID::" + id));
    }

    public int createProduct(ProductRequest productReq) {
        Product product =mapper.toProduct(productReq);
        repo.save(product);
        return product.getProductId();
    }

    public List<PurchasedProductResponse> purchaseProduct(List<PurchaseProductRequest> request){
        var productIds =request
                        .stream()
                        .map(PurchaseProductRequest::productId)
                        .toList();
        var storedProducts =repo.findAllByIdInOrderId(productIds);
        if(productIds.size() != storedProducts.size()){
            throw new ProductPurchaseException("One or more products doesn't exists");
        }

        var storedRequest = request
                                .stream()
                                .sorted(Comparator.comparing(PurchaseProductRequest::productId))
                                .toList();

        var purchasedProducts = new ArrayList<PurchasedProductResponse>();
        for(int i=0; i<storedProducts.size();i++){
            var product = storedProducts.get(i);
            var productRequest =storedRequest.get(i);

            if(product.getAvailableQuantity()< productRequest.quanity()){
                throw new ProductPurchaseException("Insufficient stock quantity for product with the id::" + productId);
            }

            var newAvailableQuantity = product.getAvailableQuantity()- productRequest.quanity();
            product.setAvailableQuantity(newAvailableQuantity);
            repo.save(product);

            purchasedProducts.add(mapper.toProductPurchaseResponse(product,productRequest.quantity()));
        }
    }

    public int deleteProduct(int id) {
         repo.deleteById(id);
        return id;
        
    }

}
