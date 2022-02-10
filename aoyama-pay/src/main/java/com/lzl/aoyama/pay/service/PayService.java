package com.lzl.aoyama.pay.service;

import com.lzl.aoyama.pay.entity.PayRecordEntity;

/**
 * @Author lzl
 * @Date 2022/1/29 3:45
 * @Description:
 */
public interface PayService {

    void pay(PayRecordEntity payRecordEntity);
}
