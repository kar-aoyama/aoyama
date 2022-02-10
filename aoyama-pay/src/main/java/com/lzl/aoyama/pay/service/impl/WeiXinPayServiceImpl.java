package com.lzl.aoyama.pay.service.impl;

import com.lzl.aoyama.pay.entity.PayRecordEntity;
import com.lzl.aoyama.pay.repository.PayRepository;
import com.lzl.aoyama.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lzl
 * @Date 2022/1/29 3:46
 * @Description:
 */
@Service
public class WeiXinPayServiceImpl implements PayService {

    @Autowired
    private PayRepository payRepository;

    @Override
    public void pay(PayRecordEntity payRecordEntity) {
        payRepository.save(payRecordEntity);
    }
}
