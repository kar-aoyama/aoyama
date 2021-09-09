package com.lzl.aoyama.auth.controller;

import com.lzl.aoyama.auth.msg.TestProducer;
import com.lzl.aoyama.common.annotation.PermissionCheck;
import com.lzl.aoyama.common.msg.MsgContent;
import com.lzl.aoyama.common.response.CommonResponse;
import com.lzl.aoyama.common.util.UUidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba@onlying.cn
 * @date 2021/9/8 17:18
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    TestProducer testProducer;

    @PermissionCheck(required = false)
    @GetMapping("sendMsg")
    public CommonResponse<String> sendMsg(@RequestParam String msg,@RequestParam String to) {
        MsgContent msgContent = new MsgContent();
        msgContent.setContent(msg);
        msgContent.setId(UUidUtil.uid());
        msgContent.setTo(new String[]{to});
        testProducer.send(msgContent);
        return CommonResponse.success("SUCCESS");
    }
}
