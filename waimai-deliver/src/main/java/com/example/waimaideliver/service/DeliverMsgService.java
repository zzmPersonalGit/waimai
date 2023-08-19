package com.example.waimaideliver.service;

import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.controller.DeliverMsg;
import com.example.waimaideliver.entity.Deliver;

public interface DeliverMsgService {
    Result updataMsg(Deliver deliver);
}
