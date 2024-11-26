package com.arun.spring_reddis_cache.controller;

import com.arun.spring_reddis_cache.model.Products;
import com.arun.spring_reddis_cache.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get/cache")
    public List<Products> fetchAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/store/cache")
    public ResponseEntity<Products> storeProduct(@RequestBody Products products) {
         Products product = productService.saveProduct(products);
         return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping("/cache/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
         productService.deleteProductById(id);
         return ResponseEntity.ok().body("Deleted Successfully");
    }

    // Test without cache
    @GetMapping("/get")
    public List<Products> fetchAllProductsWithoutCache() {
        return productService.getAllProductsWithoutCache();
    }

}
