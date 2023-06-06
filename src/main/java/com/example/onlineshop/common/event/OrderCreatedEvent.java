package com.example.onlineshop.common.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderCreatedEvent extends BaseEvent{

    private Long totalPrice;

    public OrderCreatedEvent(String id , Long totalPrice) {
        super(id);
        this.totalPrice = totalPrice;
    }
}

