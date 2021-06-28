package com.onlinebroker.OrderManagementService.domain;

import com.onlinebroker.OrderManagementService.dto.requestDTO.OrderRequestDTO;
import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;
import com.onlinebroker.OrderManagementService.persistence.service.OrderServiceImpl;
import com.onlinebroker.OrderManagementService.serviceCommunication.OrderPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderManagementServiceImpl implements OrderManagementServiceInterface {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @Autowired
    private RabbitTemplate template;

    public void addOrder(OrderRequestDTO orderDTO) {
        this.orderServiceImpl.saveOrder(orderDTO);
        new OrderPublisher().publishOrderOnExchange(orderDTO, template);
    }

    public ArrayList<OrderEntity> getAllOrders(String userId) {
        return orderServiceImpl.getAllOrders(userId);
    }

    public OrderEntity getSingleOrder(String userId) {
        return orderServiceImpl.getSingleOrder(userId);
    }
}
