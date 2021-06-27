package com.onlinebroker.OrderManagementService.domain;

import com.onlinebroker.OrderManagementService.dto.OrderDTO;
import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;

import java.util.ArrayList;

public interface OrderManagementServiceInterface {
    void addOrder(OrderDTO orderDTO);

    ArrayList<OrderEntity> getAllOrders(String userId);

    OrderEntity getSingleOrder(String userId);
}
