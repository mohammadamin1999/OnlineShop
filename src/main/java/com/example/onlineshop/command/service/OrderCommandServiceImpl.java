package com.example.onlineshop.command.service;

import com.example.onlineshop.command.command.OrderCreatedCommand;
import com.example.onlineshop.command.command.OrderUpdateCommand;
import com.example.onlineshop.command.dto.OrderCreatedRequest;
import com.example.onlineshop.command.dto.OrderUpdatedRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final CommandGateway commandGateway;

    public OrderCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createOrder(OrderCreatedRequest request) {
        return commandGateway.send(new OrderCreatedCommand(
                UUID.randomUUID().toString(),
                request.getTotalPrice()
        ));
    }

    @Override
    public CompletableFuture<String> updateOrder(OrderUpdatedRequest request) {
        return commandGateway.send(new OrderUpdateCommand(
                request.getOrderId(),
                request.getTotalPrice()
        ));
    }
}
