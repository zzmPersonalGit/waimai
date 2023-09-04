package com.example.waimaiorder.common.util;

import com.example.waimaiorder.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.waimaiorder.common.Constants.RabbitMQCons.ORDER_EXCHANGE;
import static com.example.waimaiorder.common.Constants.RabbitMQCons.ORDER_QUEUE;

@Component
public class RabbitMQSendAddOrderUtil {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void createOrder(Order order) {
        rabbitTemplate.convertAndSend(ORDER_EXCHANGE, ORDER_QUEUE, order, message -> {
            message.getMessageProperties().setExpiration("1800000"); // 设置TTL为30分钟
            return message;
        });
    }

}
