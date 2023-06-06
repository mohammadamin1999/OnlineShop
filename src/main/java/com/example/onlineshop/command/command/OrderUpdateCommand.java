package com.example.onlineshop.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderUpdateCommand extends BaseCommand{

    private Long totalPrice;


    public OrderUpdateCommand(String id, Long totalPrice) {
        super(id);
        this.totalPrice = totalPrice;
    }
}
