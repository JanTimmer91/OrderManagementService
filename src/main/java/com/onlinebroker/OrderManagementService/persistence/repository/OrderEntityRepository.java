package com.onlinebroker.OrderManagementService.persistence.repository;

import com.onlinebroker.OrderManagementService.persistence.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderEntityRepository extends CrudRepository<OrderEntity, String> {
    OrderEntity findOrderByOrderId(String orderId);
    ArrayList<OrderEntity> findOrdersByUserId(String userId);
}