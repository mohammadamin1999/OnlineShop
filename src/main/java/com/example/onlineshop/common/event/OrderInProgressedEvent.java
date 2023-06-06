package com.example.onlineshop.common.event;

import lombok.Getter;

@Getter
public class OrderInProgressedEvent extends BaseEvent{

    private String status;

    public OrderInProgressedEvent(String id , String status){
        super(id);
        this.status = status;
    }
}
