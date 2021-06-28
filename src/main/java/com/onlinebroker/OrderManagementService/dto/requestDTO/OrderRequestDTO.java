package com.onlinebroker.OrderManagementService.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private String orderId;
    private String userId;
    private String type;
    private String stockSymbol;
    private double price;
    private int units;
    private Date date;
}
