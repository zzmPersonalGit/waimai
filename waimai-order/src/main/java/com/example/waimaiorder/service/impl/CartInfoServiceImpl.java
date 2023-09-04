package com.example.waimaiorder.service.impl;

import com.example.waimaiorder.common.util.CartInfoKeyUtil;
import com.example.waimaiorder.common.util.ConvertUtil;
import com.example.waimaiorder.common.util.RedisUtil;
import com.example.waimaiorder.common.util.ThreadPoolUtils;
import com.example.waimaiorder.entity.CartInfo;
import com.example.waimaiorder.dao.CartInfoDao;
import com.example.waimaiorder.service.CartInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.example.waimaiorder.common.Constants.Cons.CARTINFOKEY;
import static com.example.waimaiorder.common.Constants.Cons.REDIS_INDEX_DB;

/**
 * 购物车内商品信息(CartInfo)表服务实现类
 *
 * @author makejava
 * @since 2023-08-21 13:50:53
 */
@Slf4j
@Service
public class CartInfoServiceImpl implements CartInfoService {
    @Resource
    private CartInfoDao cartInfoDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ConvertUtil convertUtil;
    @Autowired
    private CartInfoKeyUtil cartInfoKeyUtil;


    /**
     * 重试三次
     *
     * @Retryable的参数说明： •value：抛出指定异常才会重试
     * •include：和value一样，默认为空，当exclude也为空时，默认所以异常
     * •exclude：指定不处理的异常
     * •maxAttempts：最大重试次数，默认3次
     * •backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L；
     * multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试
     */
    @Retryable(value = RetryException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1))
    @Override
    public void addFood(Integer cartId, Integer foodId) {

        String infoKey = cartInfoKeyUtil.cartInfoKey(cartId, foodId);
        List cartInfoList = redisUtil.getHash(CARTINFOKEY, REDIS_INDEX_DB, infoKey);
        //缓存中不存在
        if (cartInfoList == null){

            CartInfo cartInfo = cartInfoDao.queryByCartIdAndFoodId(cartId, foodId);

            if (cartInfo == null){
                //数据库里也没有
                cartInfo = new CartInfo();
                //初始数量
                int number = 1;
                //当前时间
                Date addTime = new Date();
                cartInfo.addCartInfo(cartId, foodId, number, addTime);
                int insert = cartInfoDao.insert(cartInfo);
                if (insert == 0){
                    log.info("插入信息失败");
                    throw new RetryException("插入信息失败");
                }
            }else {
                //数据库里有
                cartInfo.setNumber(cartInfo.getNumber() + 1);
                int update = cartInfoDao.update(cartInfo);
                if (update == 0){
                    log.info("插入信息失败");
                    throw new RetryException("插入信息失败");
                }
            }
            //重建缓存
            ThreadPoolUtils.execute(new Runnable() {
                @Override
                public void run() {
                    addCartInfoCache();
                }
            });
        }else {
            //缓存中存在
            CartInfo cartInfo = convertUtil.objToCartInfo(cartInfoList.get(0));
            cartInfo.setNumber(cartInfo.getNumber() + 1);
            int update = cartInfoDao.update(cartInfo);
            if (update == 0){
                log.info("cartinfo信息更新失败");
                throw new RetryException("cartinfo更新信息失败");
            }else {
                log.info("cartInfo信息更新成功");
            }
        }
    }

    @Override
    public CartInfo queryByCartId(Integer cartId) {
        List<CartInfo> cartInfoList = cartInfoDao.queryByCartId(cartId);
        return null;
    }

    /*重建缓存*/
    public void addCartInfoCache(){

        //判断是否存在这个key，有则删除
        Boolean exist = redisUtil.exist(CARTINFOKEY, REDIS_INDEX_DB);
        if (exist){
            Long remove = redisUtil.remove(CARTINFOKEY, REDIS_INDEX_DB);
        }

        List<CartInfo> cartInfoList = cartInfoDao.queryAll();
        HashMap<String, String> map = new HashMap<>();
        for (CartInfo cartInfo : cartInfoList) {
            String cartinfokey = cartInfoKeyUtil.cartInfoKey(cartInfo.getCartId(), cartInfo.getFoodId());
            map.put(cartinfokey, convertUtil.objectToString(cartInfo));
        }
        String setHash = redisUtil.setHash(CARTINFOKEY, map, REDIS_INDEX_DB);
        if ("OK".equals(setHash)){
            log.info("cartinfo表缓存操作成功");
        }
    }
}
