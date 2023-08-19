package com.example.waimaideliver.service.serviceImpl;

import com.example.waimaideliver.common.Util.SMSUtil;
import com.example.waimaideliver.common.Util.isValidPhoneNumberUtil;
import com.example.waimaideliver.common.enums.ErrorCodeEnum;
import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.entity.Deliver;
import com.example.waimaideliver.mapper.DeliverDao;
import com.example.waimaideliver.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;


@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    DeliverDao deliverDao;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /*获取短信验证码*/
    @Override
    public Result getVerCode(String phoneNumbe) throws ExecutionException, InterruptedException {



        if (!isValidPhoneNumberUtil.isValidPhoneNumber(phoneNumbe)){
            return  Result.error(ErrorCodeEnum.PHONE_NUMBER_ERROR);
        }
        String code = SMSUtil.SMSRedis(phoneNumbe);
        if (code != null && !"".equals(code)){
            return new Result(code);
        }

        return Result.error(ErrorCodeEnum.GET_VER_CODE);
    }

    /*添加骑手用户*/
    @Transactional
    @Override
    public Result addDeliver(String phoneNUmmber, String smsVerCode) {


        try {
            /*从redis中获取验证码*/
            String SMS = (String) redisTemplate.opsForValue().get("SMSVerificationCode");
            //判断验证码是否过期
            if ("".equals(SMS) || SMS == null) {
                return Result.error(ErrorCodeEnum.SMS_VER_EXPIRED);
            }
            /*判断验证码是否为空*/
            if (smsVerCode == null || "".equals(smsVerCode)){
                return Result.error(ErrorCodeEnum.SMS_VER_CODE_NULL);
            }
            //判断验证码是否正确
            if (!smsVerCode.equals(SMS)) {
                return Result.error(ErrorCodeEnum.SMS_VER_CODE_ERROR);
            }
            //默认用户无密码，仅支持手机登录，用户名默认手机号
            Deliver deliver = new Deliver();
            deliver.addDefaultDeliver(phoneNUmmber, phoneNUmmber);
            //向数据库添加用户
            int insert = deliverDao.insert(deliver);
            if (insert != 0){
                return new Result(102,"注册成功",deliver);
            }

            return Result.error(ErrorCodeEnum.System_ERROR);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
