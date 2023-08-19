package com.example.waimaiadmin.config;

import com.example.waimaiadmin.entity.DeliverLincense;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQListenerConfig {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "deliverMsgAudit.queue"),
            exchange = @Exchange(name = "deliver.direct", type = ExchangeTypes.DIRECT),
            key = {"deliverMsg"}
    ))
    public void deliverListener(DeliverLincense deliverLincense){
        System.out.println(deliverLincense);
    }


}
