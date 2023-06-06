package com.example.onlineshop.query.repository;

import com.example.onlineshop.query.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product , String> {
}
