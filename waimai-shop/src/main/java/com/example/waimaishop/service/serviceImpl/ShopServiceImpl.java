package com.example.waimaishop.service.serviceImpl;

import com.example.waimaishop.common.enums.ErrorCodeEnum;
import com.example.waimaishop.common.response.Result;
import com.example.waimaishop.common.util.ConvertUtil;
import com.example.waimaishop.common.util.RedisUtil;
import com.example.waimaishop.common.util.ThreadPoolUtils;
import com.example.waimaishop.dao.ShopDao;
import com.example.waimaishop.entity.Shop;
import com.example.waimaishop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

import static com.example.waimaishop.common.Constants.Cons.REDIS_INDEX_DB;
import static com.example.waimaishop.common.Constants.Cons.SHOPKEY;

@Slf4j
@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopDao shopDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;
    @Autowired
    private ConvertUtil convertUtil;

    @Override
    public Result queryByShopId(Integer shopId) {

        Shop shop = shopDao.queryById(shopId);
        if (shop == null){
            return Result.error(ErrorCodeEnum.SHOP_NOT_EXIST);
        }else {
            threadPoolUtils.execute(new Runnable() {
                @Override
                public void run() {
                    addShopCache();
                }
            });
        }
        return new Result(shop);
    }

    public void addShopCache(){
        Boolean exist = redisUtil.exist(SHOPKEY, REDIS_INDEX_DB);
        if (exist){
            redisUtil.remove(SHOPKEY, REDIS_INDEX_DB);
        }

        List<Shop> shopList = shopDao.queryByAll();
        HashMap<String, String> map = new HashMap<>();
        for (Shop shop : shopList) {
            map.put(shop.getId().toString(), convertUtil.objectToString(shop));
        }
        String setHash = redisUtil.setHash(SHOPKEY, map, REDIS_INDEX_DB);
        if ("OK".equals(setHash)){
            log.info("shop表缓存更新成功");
        }else {
            log.info("shop表更新失败");
            throw new RuntimeException("shop表更新失败");
        }
    }
}
