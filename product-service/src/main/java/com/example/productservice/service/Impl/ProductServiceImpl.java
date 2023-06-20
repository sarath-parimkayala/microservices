package com.example.productservice.service.Impl;

import com.example.productservice.entity.Product;
import com.example.productservice.model.ProductRequest;
import com.example.productservice.model.ProductResponse;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public ProductResponse addProduct(ProductRequest request) {

        Product product = Product.builder()
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .productName(request.getProductName())
                .build();
        product = productRepository.save(product);
        ProductResponse productResponse = ProductResponse.builder().productId(product.getProductId()).productName(product.getProductName()).price(product.getPrice()).quantity(product.getQuantity()).build();
        return productResponse;
    }

    @Override
    public ProductResponse getProducts(Long productId) {
       Product result = productRepository.findById(productId).get();
       ProductResponse productResponse = new ProductResponse();
       copyProperties(result, productResponse);
       return productResponse;
    }

    @Override
    public void reduceQuantity(Long productId, Long quantity) {
        Product result = productRepository.findById(productId).get();
       /* Product product = new Product();
        copyProperties(result, product);
        product.setQuantity(result.getQuantity()-quantity);*/
        result.setQuantity(result.getQuantity()-quantity);
        productRepository.save(result);
    }
}
