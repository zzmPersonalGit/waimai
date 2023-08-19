package com.example.waimaideliver.common.Util;

import com.example.waimaideliver.common.aliyunmessage.SendVerCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class SMSUtil {

    private SMSUtil(){}

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        SMSUtil.redisTemplate = redisTemplate;
    }

    public static String SMSRedis(String phoneNumbe) throws ExecutionException, InterruptedException {

        SendVerCode sendVerCode = new SendVerCode();

        String code = CreatVerCodeUtil.getCode();
        String sendResult = sendVerCode.Send(code, phoneNumbe);

        redisTemplate.opsForValue().set("SMSVerificationCode",code,1, TimeUnit.MINUTES);
        if ("OK".equals(sendResult)){

            System.out.println(code);
            /*验证码存入redis*/
            redisTemplate.opsForValue().set("wh", "wagnhui");
            redisTemplate.opsForValue().set("SMSVerificationCode",code);

            return code;
        }
        return null;
    }
}
