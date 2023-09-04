package com.example.waimaishop.service.serviceImpl;

import com.example.waimaishop.common.enums.ErrorCodeEnum;
import com.example.waimaishop.common.response.Result;
import com.example.waimaishop.common.util.ConvertUtil;
import com.example.waimaishop.common.util.RedisUtil;
import com.example.waimaishop.common.util.ThreadPoolUtils;
import com.example.waimaishop.dao.ShopInfoDao;
import com.example.waimaishop.entity.ShopInfo;
import com.example.waimaishop.service.ShopInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static com.example.waimaishop.common.Constants.Cons.REDIS_INDEX_DB;
import static com.example.waimaishop.common.Constants.Cons.SHOPINFOKEY;

@Slf4j
@Service
public class ShopInfoServiceImpl implements ShopInfoService {

    @Resource
    private ShopInfoDao shopInfoDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ConvertUtil convertUtil;
    @Autowired
    private ThreadPoolUtils threadPoolUtils;

    /*根据 shoplist 查询数据*/
    @Override
    public Result findShopInfoByShopId(Integer shopId) {

        Boolean exist = redisUtil.hexist(SHOPINFOKEY, REDIS_INDEX_DB, shopId.toString());
        ShopInfo shopInfo = new ShopInfo();

        //建立整个缓存
        if (!exist){

            shopInfo = shopInfoDao.queryByShopId(shopId);
            //判断缓存 redis 中是否存在该部分数据，如果存在只更新 shopidlist 部分
            //不存在返回消息
            if (shopInfo == null){
                return Result.error(ErrorCodeEnum.SHOPINFO_NOT_EXIST);
            }

            try {
                threadPoolUtils.execute(new Runnable() {
                    @Override
                    public void run() {
                        Boolean aBoolean = creatShopInfoCacher();
                        if (aBoolean){
                            log.info("建立缓存成功");
                        }
                        log.info("建立缓存失败");
                    }
                });
            } catch (Exception e) {
                log.info(e.getMessage());
                throw new RuntimeException(e);
            }
        }else {
            List hash = redisUtil.getHash(SHOPINFOKEY, REDIS_INDEX_DB.shortValue(), shopId.toString());
            shopInfo = (ShopInfo) hash.get(0);
        }
        return new Result(shopInfo);
    }

    /*建立 shopinfo 缓存*/
    @Override
    public Boolean creatShopInfoCacher() {

        Boolean exist = redisUtil.exist(SHOPINFOKEY, REDIS_INDEX_DB);
        if (exist){
            redisUtil.remove(SHOPINFOKEY, REDIS_INDEX_DB);
        }

        List<ShopInfo> shopInfoList = shopInfoDao.queryAll();
        Map<String, String> shopInfoMap = new HashMap<>();
        for (ShopInfo shopInfo : shopInfoList) {
            shopInfoMap.put(shopInfo.getId().toString(), convertUtil.objectToString(shopInfo));
        }
        String setHash = redisUtil.setHash(SHOPINFOKEY, shopInfoMap, REDIS_INDEX_DB);
        if ("OK".equals(setHash)){
            return true;
        }
        return false;
    }
}
