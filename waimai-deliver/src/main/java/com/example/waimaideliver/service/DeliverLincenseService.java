package com.example.waimaideliver.service;

import com.example.waimaideliver.common.response.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DeliverLincenseService {

    Result updataDeliverLincense(Integer deliverId, String idcardNum, MultipartFile idcardImg, MultipartFile idcardImgBack, MultipartFile healthImg, MultipartFile images);

    Result updataDeliverLinStatus(List<Integer> deliverLinIdList);
}
