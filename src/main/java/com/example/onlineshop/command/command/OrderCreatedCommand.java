package com.example.onlineshop.command.command;

import lombok.Data;

@Data
public class OrderCreatedCommand extends BaseCommand{

    private Long totalPrice;

    public OrderCreatedCommand(String id , Long totalPrice){
        super(id);
        this.totalPrice = totalPrice;
    }
}
