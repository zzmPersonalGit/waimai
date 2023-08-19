package com.example.waimaideliver.common.aliyunmessage;


import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.google.gson.Gson;
import darabonba.core.client.ClientOverrideConfiguration;

import java.util.concurrent.CompletableFuture;

public class SendSms {
    public static void main(String[] args) throws Exception {

        long rand = (long)(Math.random()*900000+100000);
        String code = String.valueOf(rand);

        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId("LTAI5t6xeejPeA4Q3zAgaasp")
                .accessKeySecret("xxMdN2zXAcbU9tv3wS3EfBH72MdELI")
                .build());

        AsyncClient client = AsyncClient.builder()
                .region("cn-hangzhou") // Region ID
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride("dysmsapi.aliyuncs.com")
                )
                .build();

        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .phoneNumbers("18982370124")
                .signName("周忠明的博客")
                .templateParam("{\"code\":\""+code+"\"}")
                .templateCode("SMS_276347072")
                .build();


        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);

        SendSmsResponse resp = response.get();
        System.out.println(new Gson().toJson(resp));

        client.close();
    }

}