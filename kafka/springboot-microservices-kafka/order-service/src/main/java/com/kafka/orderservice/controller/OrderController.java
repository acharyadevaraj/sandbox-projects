package com.kafka.orderservice.controller;

import com.kafka.basedomains.model.Order;
import com.kafka.basedomains.model.OrderEvent;
import com.kafka.orderservice.config.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @GetMapping("/placeOrder")
    public String orderPlaced(@RequestBody Order order) {
        order.setId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state");
        orderProducer.sendMessage(orderEvent);
        return "Order Placed Successfully";
    }
}
