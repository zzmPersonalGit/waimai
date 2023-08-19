package com.example.waimaideliver.common.aliyunmessage;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.google.gson.Gson;
import darabonba.core.client.ClientOverrideConfiguration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SendVerCode {

    public String Send(String code, String phoneNumber) throws ExecutionException, InterruptedException {


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
                .phoneNumbers(phoneNumber)
                .signName("周忠明的博客")
                .templateParam("{\"code\":\""+code+"\"}")
                .templateCode("SMS_276347072")
                .build();


        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);

        SendSmsResponse resp = response.get();
        String code1 = resp.getBody().getCode();

        System.out.println(new Gson().toJson(resp));

        client.close();
        return code1;
    }


}
