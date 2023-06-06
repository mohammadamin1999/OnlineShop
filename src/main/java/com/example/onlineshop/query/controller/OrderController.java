package com.example.onlineshop.query.controller;

import com.example.onlineshop.query.entity.Order;
import com.example.onlineshop.query.query.FindOrderByIdQuery;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage-order")
public class OrderController {

    private final QueryGateway queryGateway;

    public OrderController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable String id){
        Order order = queryGateway.query(new FindOrderByIdQuery(id), Order.class).join();
        if(order == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order , HttpStatus.OK);
    }
}
