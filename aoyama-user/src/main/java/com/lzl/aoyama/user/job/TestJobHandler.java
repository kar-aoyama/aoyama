package com.lzl.aoyama.user.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @Author lzl
 * @Date 2022/2/18 16:49
 * @Description:
 */
@Component
public class TestJobHandler {

    @XxlJob("testJobHandler")
    public ReturnT<String> test(){



    }
}
