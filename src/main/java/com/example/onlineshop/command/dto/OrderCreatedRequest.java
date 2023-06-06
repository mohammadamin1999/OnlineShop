package com.example.onlineshop.command.dto;

import lombok.Data;

@Data
public class OrderCreatedRequest {
    private Long totalPrice;
}
