package com.example.onlineshop.query.service;

import com.example.onlineshop.common.event.OrderCreatedEvent;
import com.example.onlineshop.common.event.OrderUpdateEvent;
import com.example.onlineshop.query.entity.Order;
import com.example.onlineshop.query.query.FindOrderByIdQuery;
import com.example.onlineshop.query.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    @EventHandler
    public void on(OrderCreatedEvent event) {
        log.info("Handling OrderCreatedEvent .....");
        Order order = new Order();
        order.setStatus("CREATED");
        order.setTotalPrice(event.getTotalPrice());
        orderRepository.save(order);
    }

    @Override
    @EventHandler
    public void on(OrderUpdateEvent event) {
        log.info("Handling OrderUpdateEvent .....");
        Optional<Order> orderOptional = orderRepository.findById(event.getId());
        if(orderOptional.isPresent()){
            Order order = orderOptional.get();
            order.setTotalPrice(event.getTotalPrice());
            order.setStatus("IN_PROGRESS");
            orderRepository.save(order);
        }
    }

    @Override
    @QueryHandler
    public Order getOrder(FindOrderByIdQuery findOrderByIdQuery) {
        log.info("Handling FindOrderByIdQuery .....");
        Optional<Order> orderOptional = orderRepository.findById(findOrderByIdQuery.getOrderId());
        if (orderOptional.isPresent()) {
            return orderOptional.get();
        }
        return null;
    }


}
