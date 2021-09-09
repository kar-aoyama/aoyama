package com.lzl.aoyama.common.msg;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/9/8 16:51
 * @Description:
 */
@Component
public class MessageQueueMsgSubscription {

    @StreamListener(value = Sink.INPUT)
    public void pointConsumer(String msg) {
        consumer(msg);
    }

    private void consumer(String msg) {
        System.out.println(msg);
    }
}
