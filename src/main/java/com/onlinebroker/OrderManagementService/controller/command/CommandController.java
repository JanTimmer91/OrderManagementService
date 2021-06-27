package com.onlinebroker.OrderManagementService.controller.command;

import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;
import com.onlinebroker.OrderManagementService.domain.OrderManagementServiceImpl;
import com.onlinebroker.OrderManagementService.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CommandController {

    private final OrderManagementServiceImpl orderManagementServiceImpl;

    public CommandController(OrderManagementServiceImpl orderManagementServiceImpl){
        this.orderManagementServiceImpl = orderManagementServiceImpl;
    }

    @PostMapping(value = "/orderService/orders")
    @CrossOrigin(origins = {"http://localhost:3000"}) //for local development
    public void addOrder(@RequestBody OrderDTO orderDTO) {
        orderManagementServiceImpl.addOrder(orderDTO);
    }
}