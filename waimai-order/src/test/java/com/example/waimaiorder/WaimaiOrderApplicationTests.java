package com.example.waimaiorder;


import com.example.waimaiorder.common.response.Result;
import com.example.waimaiorder.common.util.ConvertUtil;
import com.example.waimaiorder.common.util.RedisUtil;
import com.example.waimaiorder.common.util.ThreadPoolUtils;
import com.example.waimaiorder.entity.Food;
import com.example.waimaiorder.entity.User;
import com.example.waimaiorder.feignClient.CommondityserviceFeign;
import com.example.waimaiorder.feignClient.ShopserviceFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.checkerframework.checker.units.UnitsTools.s;

@SpringBootTest
class WaimaiOrderApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CommondityserviceFeign commondityserviceFeign;

    @Autowired
    private ShopserviceFeign shopserviceFeign;

    @Autowired
    private ConvertUtil convertUtil;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;


    @Test
    void redisAddFoodMsg() {

        Jedis jedis = new Jedis("192.168.60.131", 6379);
        jedis.auth("123456");
        jedis.select(0);
        Map<String, Food> stringFoodMap = new HashMap<>();

        Food food = new Food();
        food.setId(3);
        food.setTitle("烤鸭,烤鸡");
        food.setCover("husgh");

        Food food2 = new Food();
        food2.setId(2);
        food2.setTitle("烤鱼");
        food2.setCover("wh");

        ArrayList<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food2);

        byte[] food1 = SerializationUtils.serialize(foods);
        byte[] foodskey = SerializationUtils.serialize(food1);

        jedis.set(foodskey ,food1);

        byte[] bytes = jedis.get(foodskey);
        List<Food> foods2 = (List<Food>)SerializationUtils.deserialize(bytes);
        for (Food food3 : foods2) {
            System.out.println(food3.getTitle());
        }

        jedis.close();


        /*String set = redisUtil.set("zzm", "wh", 0);
        System.out.println(set);

        String zzm = redisUtil.get("zzm", 0);*/


    }

    @Test
    void ommondityserviceFeignTest(){

        Food food = commondityserviceFeign.foodFind(10);
        System.out.println(food);
    }

    @Test
    void threadTest(){

        new Thread(){

            @Override
            public synchronized void start() {
                System.out.println(new Date());
                super.start();
            }
        }.start();

        new Thread(){

            @Override
            public synchronized void start() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(new Date());
                super.start();
            }
        }.start();


    }

    @Test
    void shopServiceFeignTest(){
        List<Integer> list = new ArrayList<>();
        list.add(18);
        list.add(8);
        list.add(0);

        String s = convertUtil.ListToString(list);

        /*List<Integer> integers = JSON.parseArray(s, Integer.class);*/
        /*List list1 = convertUtil.StringToList(s, new Integer(1));
        System.out.println(list1);*/
        Result shopinfoservice = shopserviceFeign.shopinfoservice(s);
        System.out.println(shopinfoservice.getData());

    }

    @Test
    void redisTest(){

        List foodlist = redisUtil.getHash("foodlist", 0, "1000");
        System.out.println(foodlist);
        if (foodlist.get(0) == null){
            System.out.println("为空");
        }
        /*Object o =  foodlist.get(0);
        Food food = convertUtil.objToEntity(o);
        System.out.println(food);*/
    }

    @Test
    void RunnabTest() throws ExecutionException, InterruptedException {
        Future future = threadPoolUtils.submit(new Callable() {
            @Override
            public Food call() throws Exception {
                Food food = new Food();
                food.setTitle("烤鸭");
                return food;
            }
        });

        System.out.println(future.get());

    }
}
