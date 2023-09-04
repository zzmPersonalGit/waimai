package com.example.waimaicoupon.common.util;

import com.alibaba.fastjson2.JSON;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ConvertUtil<T> {

    /*Liset转换为String*/
    public String ListToString(List list ){

        String string = JSON.toJSON(list).toString();
        return string;
    }

    /*String转换为List*/
    public <K> List StringToList(String data, K cla){

        List<K> list = new ArrayList<>();
        list = (List<K>) JSON.parseArray(data ,cla.getClass());
        return list;
    }

    /*map转换为String*/
    public String mapToString(Map map){
        String string = JSON.toJSON(map).toString();
        return string;
    }

    /*Object转换为String*/
    public String objectToString(Object object ){

        String string = JSON.toJSON(object).toString();
        return string;
    }

}
