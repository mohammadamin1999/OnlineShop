package com.example.onlineshop.query.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class OrderProduct extends BasicEntity{

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Integer numberOfProducts;
}
