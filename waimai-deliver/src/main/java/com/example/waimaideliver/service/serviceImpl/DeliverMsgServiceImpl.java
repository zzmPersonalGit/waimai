package com.example.waimaideliver.service.serviceImpl;

import com.example.waimaideliver.common.enums.ErrorCodeEnum;
import com.example.waimaideliver.common.response.Result;
import com.example.waimaideliver.entity.Deliver;
import com.example.waimaideliver.mapper.DeliverDao;
import com.example.waimaideliver.service.DeliverMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverMsgServiceImpl implements DeliverMsgService {

    @Autowired
    DeliverDao deliverDao;

    //更新用户信息
    @Override
    public Result updataMsg(Deliver deliver) {

        int update = deliverDao.update(deliver);
        if (update != 0) {
            return new Result();
        }
        return Result.error(ErrorCodeEnum.DELIVER_MSG_UPDATA_ERROR);
    }
}
