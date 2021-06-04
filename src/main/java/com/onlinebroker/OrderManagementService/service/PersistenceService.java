package com.onlinebroker.OrderManagementService.service;

import com.onlinebroker.OrderManagementService.dto.OrderDTO;
import static com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity.*;

import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;
import com.onlinebroker.OrderManagementService.persistence.repository.OrderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

@Service
public class PersistenceService {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    public void saveOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity
                = new OrderEntity(
                orderDTO.getOrderId(),
                orderDTO.getUserId(),
                orderDTO.getType(),
                orderDTO.getStockSymbol(),
                orderDTO.getPrice(),
                orderDTO.getUnits(),
                orderDTO.getDate()
        );

        orderEntityRepository.save(orderEntity);
    }
    public ArrayList<OrderEntity> getAllOrders(String userId) {
        return orderEntityRepository.findByUserId(userId);
    }

    public OrderEntity getSingleOrder(String orderId) {
        return orderEntityRepository.findByOrderId(orderId);
    }
}