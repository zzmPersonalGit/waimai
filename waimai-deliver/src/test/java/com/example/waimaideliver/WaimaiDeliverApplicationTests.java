package com.example.waimaideliver;

import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.entity.DeliverLincense;
import com.example.waimaideliver.service.DeliverLincenseService;
import com.example.waimaideliver.service.AddOrderService;
import com.example.waimaideliver.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static com.example.waimaideliver.common.Constants.Cons.DeliverLinMsgListKey;


@SpringBootTest
class WaimaiDeliverApplicationTests {

    @Autowired
    RegisterService registerService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private DeliverLincenseService deliverLincenseService;
    @Autowired
    private AddOrderService addOrderService;

    /*验证码测试*/
    @Test
    void sendVerCode() throws ExecutionException, InterruptedException {

        Result verCode = registerService.getVerCode("18982370124");
    }

    @Test
    void testRedis(){
        redisTemplate.opsForValue().set("wh", "wagnhui");
    }

    @Test
    void MQTest(){
        String exchangeName = "deliver.direct";
        DeliverLincense deliverLincense = new DeliverLincense();
        deliverLincense.addDeliverLincense(123,"rt","wr","eh", "wh","rh",1,new Date());

        rabbitTemplate.convertAndSend(exchangeName, "deliverMsg", deliverLincense);
    }

    @Test
    void redisTestList(){

        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(4321);
        list.add(1244);
        redisTemplate.opsForList().leftPushAll(DeliverLinMsgListKey,list);


        List<Object> range = redisTemplate.opsForList().range(DeliverLinMsgListKey, 0, -1);
        System.out.println(range);*/

        /*Boolean aBoolean = redisTemplate.hasKey(DeliverLinMsgListKey);
        if (aBoolean){
            List range = redisTemplate.opsForList().range(DeliverLinMsgListKey, 0, -1);
            range.add(1234);
            Long aLong = redisTemplate.opsForList().leftPushAll(DeliverLinMsgListKey,range);
        }
        else {
            List<Integer> list = new ArrayList<>();
            list.add(12456);
            list.add(5678);
            Long aLong = redisTemplate.opsForList().rightPush(DeliverLinMsgListKey, list);
            System.out.println(aLong);

        }*/

        /*redisTemplate.opsForList().rightPush(DeliverLinMsgListKey,74774);
        redisTemplate.opsForList().rightPush(DeliverLinMsgListKey,355);
        redisTemplate.opsForList().leftPush(DeliverLinMsgListKey,74774);*/


        List<Object> range = redisTemplate.opsForList().range(DeliverLinMsgListKey, 0, -1);
        for (Object o : range) {
            System.out.println(o);
        }
    }

    @Test
    void sqlTest(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        deliverLincenseService.updataDeliverLinStatus(list);
    }

    @Test
    void lockTest(){

        new Thread(){
            @Override
            public synchronized void start() {
                Result order = addOrderService.getOrder(1);
                try {
                    sleep(10000, 1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(order);
                super.start();
            }
        }.start();

        new Thread(){
            @Override
            public synchronized void start() {
                Result order = addOrderService.getOrder(2);
                System.out.println(order);
                super.start();
            }
        }.start();

    }


}
