package com.example.waimaideliver.service.serviceImpl;

import com.example.waimaideliver.common.Util.imageProcessUtil;
import com.example.waimaideliver.common.enums.ErrorCodeEnum;
import com.example.waimaideliver.common.enums.MyException;
import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.entity.DeliverLincense;
import com.example.waimaideliver.mapper.DeliverLincenseDao;
import com.example.waimaideliver.service.DeliverLincenseService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.waimaideliver.common.Constants.Cons.DeliverLinMsgListKey;

@Service
public class DeliverLincenseServiceImpl implements DeliverLincenseService {

    private

    @Autowired
    DeliverLincenseDao deliverLincenseDao;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    /*更新骑手认证信息*/
    @Transactional
    @Override
    public Result updataDeliverLincense(Integer deliverId,
                                        String idcardNum,
                                        MultipartFile idcardImg,
                                        MultipartFile idcardImgBack,
                                        MultipartFile healthImg,
                                        MultipartFile images) {

        //状态量，1 为未审核 ，0 为已经审核
        Integer status = 1;


        try {
            DeliverLincense deliverLincense = new DeliverLincense();

            deliverLincense.addDeliverLincense(deliverId,
                    idcardNum,
                    imageProcessUtil.ImageDeal(idcardImg),
                    imageProcessUtil.ImageDeal(idcardImgBack),
                    imageProcessUtil.ImageDeal(healthImg),
                    imageProcessUtil.ImageDeal(images),
                    status,
                    new Date()
            );

            //骑手信息加入数据库（待认证）
            int insert = deliverLincenseDao.insert(deliverLincense);
            if (insert == 0){
                throw new MyException(ErrorCodeEnum.DELIVER_LINCENSE_MSG_ERROR);
            }

            //骑手信息加入缓存
            DeliverLincense deliverLincense1 = deliverLincenseDao.queryByDeliverId(deliverId);
            Long aLong = redisTemplate.opsForList().rightPush(DeliverLinMsgListKey, deliverLincense1);
            if (aLong != 0){
                return new Result();
            }



            return Result.error(ErrorCodeEnum.System_ERROR);

        }catch (Exception e){
           return Result.error(ErrorCodeEnum.System_ERROR);
        }
    }


    @Override
    public Result updataDeliverLinStatus(List<Integer> deliverLinIdList) {

        Integer integer = deliverLincenseDao.updateLinStatus(deliverLinIdList);
        System.out.println(integer);
        return null;
    }
}
