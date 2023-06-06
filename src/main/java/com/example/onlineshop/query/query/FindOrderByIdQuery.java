package com.example.onlineshop.query.query;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindOrderByIdQuery {
    private String orderId;
}
