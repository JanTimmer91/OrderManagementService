package com.onlinebroker.OrderManagementService.persistence.service;

import com.onlinebroker.OrderManagementService.dto.requestDTO.OrderRequestDTO;
import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;

import java.util.ArrayList;

public interface OrderServiceInterface {

    void saveOrder(OrderRequestDTO orderDTO);

    ArrayList<OrderEntity> getAllOrders(String userId);

    OrderEntity getSingleOrder(String orderId);
}
