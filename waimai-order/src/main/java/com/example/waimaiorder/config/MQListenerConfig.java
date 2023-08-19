package com.example.waimaiorder.config;

import com.example.waimaiorder.entity.Order;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQListenerConfig {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "order.queue"),
            exchange = @Exchange(name = "order.direct", type = ExchangeTypes.DIRECT),
            key = {"addorder"}
    ))
    public void deliverListener(Order order){
        System.out.println(order);
    }


}
