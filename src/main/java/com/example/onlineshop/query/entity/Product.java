package com.example.onlineshop.query.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
public class Product extends BasicEntity{

    @Column(nullable = false , unique = true)
    private String name;

    @Column(nullable = false)
    private Long price;

    private Integer availableItems;

    @OneToMany
    private List<OrderProduct> orderProduct;
}
