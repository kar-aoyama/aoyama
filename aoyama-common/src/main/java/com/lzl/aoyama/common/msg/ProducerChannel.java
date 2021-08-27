package com.lzl.aoyama.common.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author lzl
 * @ClassName ProDucerChannel
 * @date: 2021/8/23 上午11:15
 * @Description:
 */
public interface ProducerChannel {

    String input = "broadCastInput";

    @Input(ProducerChannel.input)
    SubscribableChannel broadCastInput();
}
