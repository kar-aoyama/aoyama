package com.lzl.aoyama.pay.service.impl;

import com.lzl.aoyama.pay.entity.PayRecordEntity;
import com.lzl.aoyama.pay.repository.PayRepository;
import com.lzl.aoyama.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author lzl
 * @Date 2022/2/6 23:53
 * @Description:
 */
public class AlibabaPayServiceImpl implements PayService {

    @Autowired
    private PayRepository payRepository;

    @Override
    public void pay(PayRecordEntity payRecordEntity) {

    }
}
