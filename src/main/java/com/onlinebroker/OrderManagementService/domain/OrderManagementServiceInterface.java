package com.onlinebroker.OrderManagementService.domain;

import com.onlinebroker.OrderManagementService.dto.requestDTO.OrderRequestDTO;
import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;

import java.util.ArrayList;

public interface OrderManagementServiceInterface {
    void addOrder(OrderRequestDTO orderDTO);

    ArrayList<OrderEntity> getAllOrders(String userId);

    OrderEntity getSingleOrder(String userId);
}
