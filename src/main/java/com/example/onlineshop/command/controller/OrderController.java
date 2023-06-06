package com.example.onlineshop.command.controller;

import com.example.onlineshop.command.dto.OrderCreatedRequest;
import com.example.onlineshop.command.dto.OrderUpdatedRequest;
import com.example.onlineshop.command.service.OrderCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderCommandService service;

    public OrderController(OrderCommandService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<String> createOrder(@RequestBody OrderCreatedRequest request){
        try{
            return new ResponseEntity<>(service.createOrder(request).get() , HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("An Error Occurred" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };

    @PutMapping("")
    public ResponseEntity<String> updateOrder(@RequestBody OrderUpdatedRequest request){
        try{
            return new ResponseEntity<>(service.updateOrder(request).get() , HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("An Error Occurred" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };
}
