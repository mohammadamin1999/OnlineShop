package com.example.onlineshop.query.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Builder
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
