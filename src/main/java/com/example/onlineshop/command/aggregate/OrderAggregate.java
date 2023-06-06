package com.example.onlineshop.command.aggregate;


import com.example.onlineshop.command.command.OrderCreatedCommand;
import com.example.onlineshop.command.command.OrderUpdateCommand;
import com.example.onlineshop.common.event.OrderCreatedEvent;
import com.example.onlineshop.common.event.OrderInProgressedEvent;
import com.example.onlineshop.common.event.OrderUpdateEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@NoArgsConstructor
@Aggregate
@Slf4j
public class OrderAggregate {

    @AggregateIdentifier
    private String OrderId;
    private Long totalPrice;
    private String status;

    @CommandHandler
    public OrderAggregate (OrderCreatedCommand command){
      log.info("CreatedOrderCommand Received!");

      AggregateLifecycle.apply(new OrderCreatedEvent(command.getId() ,command.getTotalPrice()));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent order){
      log.info("OrderCreatedEvent occurred!");
      this.OrderId = order.getId();
      this.totalPrice = order.getTotalPrice();
      this.status = "CREATED";

      AggregateLifecycle.apply(new OrderInProgressedEvent(this.OrderId, "IN_PROGRESS"));
    }

    @EventSourcingHandler
    public void on(OrderInProgressedEvent order){
        log.info("OrderInProgressedEvent occurred!");
        this.status = order.getStatus();

        AggregateLifecycle.apply(new OrderInProgressedEvent(this.OrderId, "IN_PROGRESS"));
    }

    @CommandHandler
    public void on(OrderUpdateCommand command){
        log.info("OrderUpdateCommand Received!");
        AggregateLifecycle.apply(new OrderUpdateEvent(command.getId(), command.getTotalPrice()));
    }

    @EventSourcingHandler
    public void on(OrderUpdateEvent order){
        log.info("OrderUpdateEvent occurred!");
        this.totalPrice += order.getTotalPrice();

    }




}
