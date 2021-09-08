package com.lzl.aoyama.common.msg;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author simba@onlying.cn
 * @date 2021/9/8 16:31
 * @Description:
 */
@Component
public class MessageQueueMsgSend extends AbstractMsgProducer {

    @Autowired
    private Source source;

    @Autowired
    private BroadCastSource broadCastSource;

    @Override
    public void send(MsgContent msgContent) {
        //创建消息
        Message<MsgContent> message = createMessage(msgContent);
        //决定消息发送模式
        if (msgContent.isBroadCast())
            broadCastSource.broadCastOutput().send(message);
        else
            source.output().send(message);
    }

    public Message<MsgContent> createMessage(MsgContent msgContent) {
        Map<String, Object> headersMap = Maps.newHashMap();
        //设置广播模式
        headersMap.put(MsgTagConst.TAGS, msgContent.isBroadCast() ? MsgTagConst.BROADCAST_TAG : MsgTagConst.CLUSTER_TAG);
        MessageHeaders messageHeaders = new MessageHeaders(headersMap);
        return MessageBuilder.createMessage(msgContent, messageHeaders);
    }
}
