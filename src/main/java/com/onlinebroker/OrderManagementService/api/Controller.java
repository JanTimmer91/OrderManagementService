package com.onlinebroker.OrderManagementService.api;

import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;
import com.onlinebroker.OrderManagementService.service.OrderManagementService;
import com.onlinebroker.OrderManagementService.serviceCommunication.RabbitExchangePublisher;
import com.onlinebroker.OrderManagementService.dto.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    private final OrderManagementService orderManagementService;

    public Controller(OrderManagementService orderManagementService){
        this.orderManagementService = orderManagementService;
    }

    @Autowired
    private RabbitTemplate template;

    @PostMapping(value = "/order")
    @CrossOrigin(origins = {"http://localhost:3000"}) //for local development
    public void addOrder(@RequestBody OrderDTO orderDTO) {
        orderManagementService.addOrder(orderDTO);
        new RabbitExchangePublisher().publishOrderOnExchange(orderDTO, template);
    }

    @GetMapping(value = "/{userId}/orders")
    @CrossOrigin(origins = {"http://localhost:3000"}) //for local development
    public ArrayList<OrderEntity> getAllOrders(@PathVariable String userId) {
        return orderManagementService.getAllOrders(userId);
    }

    @GetMapping(value = "/{userId}/order")
    @CrossOrigin(origins = {"http://localhost:3000"}) //for local development
    public OrderEntity getSingleOrder(@PathVariable String orderId) {
        return orderManagementService.getSingleOrder(orderId);
    }
}