package com.example.waimaideliver.service;


import com.example.waimaideliver.common.response.Result;

import java.util.concurrent.ExecutionException;

public interface RegisterService {


    Result getVerCode(String phoneNumbe) throws ExecutionException, InterruptedException;

    Result addDeliver(String phoneNUmmber, String smsVerCode);
}
