package com.example.waimaideliver.service.serviceImpl;

import com.example.waimaideliver.common.redission.RedissonLockUtils;
import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.service.AddOrderService;
import lombok.Synchronized;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddOrderServiceImpl implements AddOrderService {

    @Autowired
    RedissonClient redissonClient;

    @Override
    public  Result getOrder(Integer orderId) {


        RedissonLockUtils distributedRedisLock = new RedissonLockUtils(redissonClient);
        boolean acquire = distributedRedisLock.acquire(orderId.toString());
        if (acquire){
            System.out.println(orderId + "获得了订单" + new Date());

            distributedRedisLock.release(orderId.toString());
            return new Result("ok");
        }
        else {
            return null;
        }

        /*System.out.println(orderId.toString()+ new Date());
        return new Result();
*/
    }
}
