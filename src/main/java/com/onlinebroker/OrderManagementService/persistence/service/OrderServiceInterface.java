package com.onlinebroker.OrderManagementService.persistence.service;

import com.onlinebroker.OrderManagementService.dto.OrderDTO;
import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;

import java.util.ArrayList;

public interface OrderServiceInterface {

    void saveOrder(OrderDTO orderDTO);

    ArrayList<OrderEntity> getAllOrders(String userId);

    OrderEntity getSingleOrder(String orderId);
}
