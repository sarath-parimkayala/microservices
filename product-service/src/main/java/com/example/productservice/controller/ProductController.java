package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.model.ProductResponse;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
        var response = productService.addProduct(productRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProducts(@PathVariable("id") Long productId){
        var response = productService.getProducts(productId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/reduceQuantity")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId, @RequestParam Long quantity){
        productService.reduceQuantity(productId,quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
