package com.example.waimaiorder.config;

import com.example.waimaiorder.common.enums.ErrorCodeEnum;
import com.example.waimaiorder.common.enums.MyException;
import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.entity.Order;
import com.example.waimaiorder.entity.OrderFood;
import com.example.waimaiorder.service.OrderFoodService;
import com.example.waimaiorder.service.OrderService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.example.waimaiorder.common.Constants.RabbitMQCons.DEAD_LETTER_QUEUE;
import static com.example.waimaiorder.common.enums.ErrorCodeEnum.ORDER_FOOD_MSG_NOT_EXIST;

@Configuration
public class MQListenerConfig {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderFoodService orderFoodService;

    /*@RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "order.queue"),
            exchange = @Exchange(name = "order.direct", type = ExchangeTypes.DIRECT),
            key = {"addorder"}
    ))
    public void deliverListener(Order order){
        System.out.println(order);
    }*/


    @RabbitListener(queues = DEAD_LETTER_QUEUE)
    public void processDeadLetter(Order order) {
        // 处理未支付订单的逻辑
        Integer id = order.getId();
        Boolean aBoolean = orderService.queryBYOrderIdForPayMag(id);
        if (aBoolean){
            //已支付
            return;
        }else {
            //未支付
            String orderId = order.getOrderId();

            List<OrderFood> orderFoodList = orderFoodService.getOrderFoodMsg(orderId);
            if (orderFoodList == null){
                throw new MyException(ErrorCodeEnum.ORDER_FOOD_MSG_NOT_EXIST);
            }


            Result result = orderService.delOrder(order.getId());
            if (result.getStatus() == 200){

            }
        }

    }


}
