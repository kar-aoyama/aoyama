package com.lzl.aoyama.auth.controller;

import com.lzl.aoyama.auth.msg.TestProducer;
import com.lzl.aoyama.common.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author simba@onlying.cn
 * @date 2021/9/8 17:18
 * @Description:
 */
@Controller
public class TestController {

    @Autowired
    TestProducer testProducer;

    @GetMapping("sendMsg")
    public CommonResponse<String> sendMsg(@RequestParam String msg) {

        return CommonResponse.success("SUCCESS");
    }
}
