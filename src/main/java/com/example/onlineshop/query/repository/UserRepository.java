package com.example.onlineshop.query.repository;

import com.example.onlineshop.query.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
