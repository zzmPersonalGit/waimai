package com.example.waimaiorder;

import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.common.util.RabbitMQSendAddOrderUtil;
import com.example.waimaiorder.common.util.UUIDUtils;
import com.example.waimaiorder.dao.OrderDao;
import com.example.waimaiorder.entity.Order;
import com.example.waimaiorder.service.CartInfoService;
import com.example.waimaiorder.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class OrderTest {

    @Autowired
    private CartInfoService cartInfoService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RabbitMQSendAddOrderUtil rabbitMQSendAddOrderUtil;
    @Resource
    private OrderDao orderDao;



    @Test
    void testUUIDUtil(){
        String s = UUIDUtils.create();
        System.out.println(s);
        String random = UUIDUtils.random();
        System.out.println(random);
    }

    @Test
    void addOrderTest(){
        Result result = orderService.addOrder(1, 1);
        System.out.println(result.getStatus());
    }

    @Test
    void te(){
        Order order = new Order();
        order.setOrderId("1");
        order.setUserId(123);
        order.setShopId(243);
        order.setBoxCost(24);
        order.setTotalMoney(2433.0);
        order.setDiscountMoney(35.0);
        order.setOrderStatus(1);
        order.setSendCost(24);

        int insert = orderDao.insert(order);
        System.out.println(insert);
    }
}
