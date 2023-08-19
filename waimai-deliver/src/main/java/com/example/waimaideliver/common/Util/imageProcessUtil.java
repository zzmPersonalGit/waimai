package com.example.waimaideliver.common.Util;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class imageProcessUtil {

    private imageProcessUtil(){}

    public static String ImageDeal(MultipartFile file){
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //返回文件名
        return fileName;
    }
}
