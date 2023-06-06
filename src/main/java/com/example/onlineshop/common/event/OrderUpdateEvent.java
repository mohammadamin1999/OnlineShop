package com.example.onlineshop.common.event;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderUpdateEvent extends BaseEvent{

    private Long totalPrice;

    public OrderUpdateEvent(String id , Long totalPrice){
        super(id);
        this.totalPrice = totalPrice;
    }
}
