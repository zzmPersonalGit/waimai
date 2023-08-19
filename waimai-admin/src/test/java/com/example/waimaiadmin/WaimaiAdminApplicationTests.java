package com.example.waimaiadmin;

import com.example.waimaiadmin.common.response.Result;
import com.example.waimaiadmin.feignClient.DeliverFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@SpringBootTest
class WaimaiAdminApplicationTests {

    @Autowired
    DeliverFeign deliverFeign;

    @Test
    void openfiegnTest() {

        Result result = deliverFeign.linStatusUpdata();

    }

}
