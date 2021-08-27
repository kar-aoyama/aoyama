package com.lzl.aoyama.common.msg;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author lzl
 * @ClassName CustomerChannel
 * @date: 2021/8/23 上午11:14
 * @Description:
 */
public interface CustomerChannel {

    String output = "broadCastOutput";

    @Output(CustomerChannel.output)
    MessageChannel broadCastOutput();
}
