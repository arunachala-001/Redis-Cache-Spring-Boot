package com.arun.spring_reddis_cache.repository;

import com.arun.spring_reddis_cache.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
