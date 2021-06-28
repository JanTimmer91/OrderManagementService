package com.onlinebroker.OrderManagementService.controller.query;

import com.onlinebroker.OrderManagementService.dto.requestDTO.OrderRequestDTO;
import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;
import com.onlinebroker.OrderManagementService.domain.OrderManagementServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class QueryController {

    private final OrderManagementServiceImpl orderManagementServiceImpl;

    public QueryController(OrderManagementServiceImpl orderManagementServiceImpl){
        this.orderManagementServiceImpl = orderManagementServiceImpl;
    }

    @GetMapping(value = "/orderService/users/{userId}/orders")
    @CrossOrigin(origins = {"http://localhost:3000"}) //for local development
    public ArrayList<OrderEntity> getAllOrders(@PathVariable String userId) {
        return orderManagementServiceImpl.getAllOrders(userId);
    }

    @GetMapping(value = "/orderService/orders/{orderId}")
    @CrossOrigin(origins = {"http://localhost:3000"}) //for local development
    public OrderEntity getSingleOrder(@PathVariable String orderId) {
        return orderManagementServiceImpl.getSingleOrder(orderId);
    }
}