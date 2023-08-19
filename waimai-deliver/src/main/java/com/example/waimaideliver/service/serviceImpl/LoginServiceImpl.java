package com.example.waimaideliver.service.serviceImpl;

import com.example.waimaideliver.common.enums.ErrorCodeEnum;
import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.entity.Deliver;
import com.example.waimaideliver.mapper.DeliverDao;
import com.example.waimaideliver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    DeliverDao deliverDao;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Deliver findByDeliverUsername(String username, String password, HttpSession session) {

        Deliver deliver = deliverDao.queryByUsername(username);
        if (deliver != null&&password.equals(deliver.getPassword())){
            /* session 存储信息*/
            session.setAttribute("deliver",deliver);
            return deliver;
        }
        return null;
    }

    @Override
    public Result loginByPhoneNumber(String phoneNumber, String smsVerCode, HttpSession session) {

        if (smsVerCode == null || "".equals(smsVerCode)){
            return Result.error(ErrorCodeEnum.SMS_VER_CODE_NULL);
        }
        /*从redis中获取验证码*/
        String SMS = (String) redisTemplate.opsForValue().get("SMSVerificationCode");
        //判断验证码是否过期
        if ("".equals(SMS) || SMS == null) {
            return Result.error(ErrorCodeEnum.SMS_VER_EXPIRED);
        }
        //判断验证码是否正确
        if (!smsVerCode.equals(SMS)) {
            return Result.error(ErrorCodeEnum.SMS_VER_CODE_ERROR);
        }
        Deliver deliver = deliverDao.queryByMobile(phoneNumber);

        if (deliver != null){
            /* session 存储信息*/
            session.setAttribute("deliver",deliver);
            return new Result(deliver);
        }
        return Result.error(ErrorCodeEnum.System_ERROR);
    }
}
