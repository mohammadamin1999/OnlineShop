package com.example.onlineshop.query.repository;

import com.example.onlineshop.query.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, String> {
}
