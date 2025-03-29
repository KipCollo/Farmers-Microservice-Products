package com.kipcollo.ecommerce.service;

import org.springframework.stereotype.Service;

import com.kipcollo.ecommerce.dto.ProductRequest;
import com.kipcollo.ecommerce.dto.ProductResponse;
import com.kipcollo.ecommerce.dto.PurchasedProductResponse;
import com.kipcollo.ecommerce.model.Category;
import com.kipcollo.ecommerce.model.Product;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProductMapper {

    public Product toProduct(ProductRequest request){
        return Product.builder()
                .productId(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .availableQuantity(request.getAvailableQuantity())
                .category(
                    Category.builder()
                        .id(request.getCategoryId())
                        .build()
                )
            .build();
    }

    public ProductResponse toProductResponse(Product product){
        return new ProductResponse(
            product.getProductId(),
            product.getName(), 
            product.getDescription(), 
            product.getAvailableQuantity(), 
            product.getPrice(), 
            product.getCategory().getId(), 
            product.getCategory().getName(),
            product.getCategory().getDescription()
           );
    }

    public PurchasedProductResponse toProductPurchaseResponse(Product product, double quantity){
        return new PurchasedProductResponse(
            product.getProductId(),
            product.getName(), 
            product.getDescription(), 
            product.getPrice(),
            quantity);
    }
}
