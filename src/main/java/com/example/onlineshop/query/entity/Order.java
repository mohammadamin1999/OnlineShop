package com.example.onlineshop.query.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Order extends BasicEntity{

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(unique = true)
    private Long trackingNumber;

    @Column(nullable = false)
    private Long totalPrice;

    private String status;

    @OneToOne
    private User user;

    @OneToMany
    private List<OrderProduct> orderProducts;

}
