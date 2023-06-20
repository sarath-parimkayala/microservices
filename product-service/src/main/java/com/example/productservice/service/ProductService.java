package com.example.productservice.service;

import com.example.productservice.entity.Product;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.model.ProductResponse;

public interface ProductService {
    ProductResponse addProduct(ProductRequest request);
    ProductResponse getProducts(Long productId);
    void reduceQuantity(Long productId , Long quantity);
}
