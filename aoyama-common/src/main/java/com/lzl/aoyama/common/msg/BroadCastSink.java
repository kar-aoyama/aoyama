package com.lzl.aoyama.common.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lzl
 * @ClassName CustomerChannel
 * @date: 2021/8/23 上午11:14
 * @Description:
 */
public interface BroadCastSink {

    String input = "broadCastInput";

    @Input(BroadCastSink.input)
    SubscribableChannel broadCastInput();
}
