package com.onlinebroker.OrderManagementService.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String orderId;
    private String userId;
    private String type;
    private String stockSymbol;
    private double price;
    private int units;
    private Date date;
}