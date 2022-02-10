package com.lzl.aoyama.pay.controller;

import com.lzl.aoyama.pay.req.PayDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lzl
 * @Date 2022/1/28 11:55
 * @Description:
 */
@RestController
public class PayController {

    @PostMapping("/pay")
    public void pay(@RequestBody PayDto payDto) {

    }


}
