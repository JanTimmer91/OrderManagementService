package com.onlinebroker.OrderManagementService.controller.command;

import com.onlinebroker.OrderManagementService.dto.requestDTO.OrderRequestDTO;
import com.onlinebroker.OrderManagementService.dto.responseDTO.MessageResponseDTO;
import com.onlinebroker.OrderManagementService.domain.OrderManagementServiceImpl;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addOrder(@RequestBody OrderRequestDTO orderDTO) {
        orderManagementServiceImpl.addOrder(orderDTO);
        return ResponseEntity.ok(new MessageResponseDTO("Item removed from watchlist!"));

    }
}