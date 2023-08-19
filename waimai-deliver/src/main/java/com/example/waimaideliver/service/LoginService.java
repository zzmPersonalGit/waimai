package com.example.waimaideliver.service;

import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.entity.Deliver;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

public interface LoginService {

    Deliver findByDeliverUsername(String username, String passwprd, HttpSession session);

    Result loginByPhoneNumber(String phoneNumber, String smsVerCode, HttpSession session);
}
