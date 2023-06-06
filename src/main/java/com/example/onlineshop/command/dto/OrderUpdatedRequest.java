package com.example.onlineshop.command.dto;

import lombok.Data;

@Data
public class OrderUpdatedRequest {
    private Long totalPrice;
    private String OrderId;
}
