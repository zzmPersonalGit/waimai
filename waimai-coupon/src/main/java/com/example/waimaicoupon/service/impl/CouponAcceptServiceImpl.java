package com.example.waimaicoupon.service.impl;

import com.example.waimaicoupon.common.enums.ErrorCodeEnum;
import com.example.waimaicoupon.common.response.Result;
import com.example.waimaicoupon.common.util.ConvertUtil;
import com.example.waimaicoupon.common.util.CouponAcceptKeyUtil;
import com.example.waimaicoupon.common.util.RedisUtil;
import com.example.waimaicoupon.common.util.ThreadPoolUtils;
import com.example.waimaicoupon.entity.CouponAccept;
import com.example.waimaicoupon.dao.CouponAcceptDao;
import com.example.waimaicoupon.service.CouponAcceptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.example.waimaicoupon.common.Constants.Cons.COUPONACCEPTKEY;
import static com.example.waimaicoupon.common.Constants.Cons.REDIS_INDEX_DB;

/**
 * 红包领取表(CouponAccept)表服务实现类
 *
 * @author makejava
 * @since 2023-08-27 11:18:11
 */
@Slf4j
@Service
public class CouponAcceptServiceImpl implements CouponAcceptService {
    @Resource
    private CouponAcceptDao couponAcceptDao;
    @Autowired
    private CouponAcceptKeyUtil couponAcceptKeyUtil;
    @Autowired
    private ConvertUtil convertUtil;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;


    @Override
    public Result queryCouponAcceptByShopIdandUserId(String couponId, Integer userId) {

        CouponAccept couponAccept = couponAcceptDao.queryByshopIdAndUserId(couponId, userId);
        if (couponAccept == null){
            return Result.error(ErrorCodeEnum.COUPONACCEPT_NOT_EXIST);
        }
        //重建红包信息缓存
        threadPoolUtils.execute(new Runnable() {
            @Override
            public void run() {
                addCouponAccept();
            }
        });
        return new Result(couponAccept);
    }

    public void addCouponAccept(){

        Boolean exist = redisUtil.exist(COUPONACCEPTKEY, REDIS_INDEX_DB);
        if (exist){
            redisUtil.remove(COUPONACCEPTKEY, REDIS_INDEX_DB);
        }

        List<CouponAccept> couponAcceptList = couponAcceptDao.queryAll();
        if (couponAcceptList == null){
            log.info("该表位空，无数据");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        for (CouponAccept couponAccept : couponAcceptList) {

            map.put(couponAcceptKeyUtil.getCouponAccerptKey(couponAccept.getCouponId(), couponAccept.getUserId()), convertUtil.objectToString(couponAccept));

        }
        String setHash = redisUtil.setHash(COUPONACCEPTKEY, map, REDIS_INDEX_DB);
        if ("OK".equals(setHash)){
            log.info("couponAccept表添加缓存成功");
        }else {
            log.info("couponAccept表添加缓存失败");
        }
    }
}
