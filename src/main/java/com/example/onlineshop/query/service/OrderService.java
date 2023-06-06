package com.example.onlineshop.query.service;

import com.example.onlineshop.common.event.OrderCreatedEvent;
import com.example.onlineshop.common.event.OrderUpdateEvent;
import com.example.onlineshop.query.entity.Order;
import com.example.onlineshop.query.query.FindOrderByIdQuery;

public interface OrderService {
    void on (OrderCreatedEvent event);
    void on (OrderUpdateEvent event);
    Order getOrder(FindOrderByIdQuery findOrderByIdQuery);
}
