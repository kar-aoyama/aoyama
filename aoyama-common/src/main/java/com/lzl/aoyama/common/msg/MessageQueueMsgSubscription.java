package com.lzl.aoyama.common.msg;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author simba@onlying.cn
 * @date 2021/9/8 16:51
 * @Description:
 */
public class MessageQueueMsgSubscription {

    @StreamListener(value = Sink.INPUT)
    public void pointConsumer(String msg) {
        consumer(msg);
    }

    @StreamListener(value = BroadCastSink.input)
    public void broadCastConsumer(String msg) {
        consumer(msg);
    }

    private void consumer(String msg) {
        System.out.println(msg);
    }
}
