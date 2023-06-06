package com.example.onlineshop.command.service;

import com.example.onlineshop.command.dto.OrderCreatedRequest;
import com.example.onlineshop.command.dto.OrderUpdatedRequest;

import java.util.concurrent.CompletableFuture;

public interface OrderCommandService {

    CompletableFuture<String> createOrder(OrderCreatedRequest request);
    CompletableFuture<String> updateOrder(OrderUpdatedRequest request);

}
