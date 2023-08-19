package com.example.waimaipay.config;

import com.example.waimaipay.entity.Pay;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQListenerConfig {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "pay.queue"),
            exchange = @Exchange(name = "order.direct", type = ExchangeTypes.DIRECT),
            key = {"pay"}
    ))
    public void deliverListener(Pay paymsg){
        System.out.println(paymsg);
    }


}
