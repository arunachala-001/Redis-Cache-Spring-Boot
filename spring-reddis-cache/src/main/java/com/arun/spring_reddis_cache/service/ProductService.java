package com.arun.spring_reddis_cache.service;

import com.arun.spring_reddis_cache.model.Products;
import com.arun.spring_reddis_cache.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "products")
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @CachePut(value = "products", key = "#products.id")
    public Products saveProduct(Products products) {
        return productRepository.save(products);

    }

    @CacheEvict(value = "products", key = "#id")
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    public List<Products> getAllProductsWithoutCache() {
        return productRepository.findAll();
    }
}
