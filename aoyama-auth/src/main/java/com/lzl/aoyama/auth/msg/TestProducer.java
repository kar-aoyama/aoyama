package com.lzl.aoyama.auth.msg;

import com.alibaba.cloud.stream.binder.rocketmq.integration.RocketMQMessageHandler;
import com.google.common.collect.Maps;
import com.lzl.aoyama.common.msg.AbstractMsgProducer;
import com.lzl.aoyama.common.msg.MsgContent;
import com.lzl.aoyama.common.msg.MsgTagConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author simba@onlying.cn
 * @date 2021/9/8 17:24
 * @Description:
 */
@Component
public class TestProducer extends AbstractMsgProducer {

    @Autowired
    private Source source;

    @Autowired
    private Sink sink;

    public void send(MsgContent msgContent) {
        //创建消息
        Message<MsgContent> message = createMessage(msgContent);
        //决定消息发送模式
        boolean send = source.output().send(message);
        System.out.println(send);
    }


    public Message<MsgContent> createMessage(MsgContent msgContent) {
        Map<String, Object> headersMap = Maps.newHashMap();
        //设置广播模式
        //  headersMap.put(MsgTagConst.TAGS, msgContent.isBroadCast() ? MsgTagConst.BROADCAST_TAG : MsgTagConst.CLUSTER_TAG);
        MessageHeaders messageHeaders = new MessageHeaders(headersMap);
        return MessageBuilder.createMessage(msgContent, messageHeaders);
    }
}
