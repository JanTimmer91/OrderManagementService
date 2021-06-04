package com.onlinebroker.OrderManagementService.service;

import com.onlinebroker.OrderManagementService.dto.OrderDTO;
import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;
import com.onlinebroker.OrderManagementService.persistence.repository.OrderEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderManagementService {

    @Autowired
    PersistenceService persistenceService;

    public void addOrder(OrderDTO orderDTO) {
        this.persistenceService.saveOrder(orderDTO);
    }

    public ArrayList<OrderEntity> getAllOrders(String userId) {
        return persistenceService.getAllOrders(userId);
    }

    public OrderEntity getSingleOrder(String userId) {
        return persistenceService.getSingleOrder(userId);
    }
}
