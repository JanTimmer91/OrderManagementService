package com.onlinebroker.OrderManagementService.serviceCommunication;

import com.onlinebroker.OrderManagementService.config.MessagingConfig;
import com.onlinebroker.OrderManagementService.dto.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitExchangePublisher {

    public void publishOrderOnExchange(OrderDTO orderDTO, RabbitTemplate template){
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderDTO);
        System.out.println("new order sent to" +MessagingConfig.EXCHANGE +"...");
    }

}
