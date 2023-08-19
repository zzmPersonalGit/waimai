package com.example.waimaideliver.controller;

import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.entity.Deliver;
import com.example.waimaideliver.service.DeliverLincenseService;
import com.example.waimaideliver.service.DeliverMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeliverMsg {

    @Autowired
    DeliverMsgService deliverMsgService;
    @Autowired
    DeliverLincenseService deliverLincenseService;

    /*个人信息维护*/
    @PostMapping("/Deliver-Msg")
    public Result DeliverMsg(@RequestBody Deliver deliver){

        return deliverMsgService.updataMsg(deliver);
    }

    /*骑手身份认证*/
    @PostMapping("/Deliver-Lincense")
    public Result DeliverLincense(@RequestParam("deliverId") Integer deliverId,
                                  @RequestParam("idcardNum") String idcardNum,
                                  @RequestParam("idcardImg") MultipartFile idcardImg,
                                  @RequestParam("idcardImgBack")MultipartFile idcardImgBack,
                                  @RequestParam("healthImg") MultipartFile healthImg,
                                  @RequestParam("images") MultipartFile images){

        return deliverLincenseService.
                updataDeliverLincense(deliverId, idcardNum, idcardImg, idcardImgBack, healthImg, images);
    }


    @GetMapping("/deliver/linStatusUpdata")
    public Result deliverLinStatusUpdata(List<Integer> deliverLinIdList){

        return deliverLincenseService.updataDeliverLinStatus(deliverLinIdList);
    };
}
