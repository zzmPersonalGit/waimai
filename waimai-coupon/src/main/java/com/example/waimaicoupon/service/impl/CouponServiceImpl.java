package com.example.waimaicoupon.service.impl;

import com.example.waimaicoupon.common.enums.ErrorCodeEnum;
import com.example.waimaicoupon.common.response.Result;
import com.example.waimaicoupon.common.util.ConvertUtil;
import com.example.waimaicoupon.common.util.RedisUtil;
import com.example.waimaicoupon.common.util.ThreadPoolUtils;
import com.example.waimaicoupon.entity.Coupon;
import com.example.waimaicoupon.dao.CouponDao;
import com.example.waimaicoupon.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.example.waimaicoupon.common.Constants.Cons.COUPONKEY;
import static com.example.waimaicoupon.common.Constants.Cons.REDIS_INDEX_DB;

/**
 * 红包发布表(Coupon)表服务实现类
 *
 * @author makejava
 * @since 2023-08-27 11:18:10
 */
@Slf4j
@Service
public class CouponServiceImpl implements CouponService {
    @Resource
    private CouponDao couponDao;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ConvertUtil convertUtil;

    @Override
    public Result queryAccountListByShopId(Integer shopId) {

        List<Coupon> couponList = couponDao.queryByShopId(shopId);

        if (couponList == null){
            return Result.error(ErrorCodeEnum.COUPON_NOT_EXIST);
        }
        threadPoolUtils.execute(new Runnable() {
            @Override
            public void run() {
                addCouponCache(couponList, shopId);
            }
        });

        return new Result(couponList);
    }

    public void addCouponCache(List<Coupon> couponList, Integer shopId){
        Boolean exist = redisUtil.exist(COUPONKEY, REDIS_INDEX_DB);
        if (exist){
            redisUtil.remove(COUPONKEY, REDIS_INDEX_DB);
        }

        String set = redisUtil.set(shopId.toString(), convertUtil.ListToString(couponList), REDIS_INDEX_DB);

        if ("OK".equals(set)) {
            log.info("coupon表添加缓存成功");
        }else {
            log.info("coupon表添加缓存失败");
        }
    }
}
