package com.lzl.aoyama.auth.msg;

import com.lzl.aoyama.common.msg.AbstractMsgProducer;
import com.lzl.aoyama.common.msg.MessageQueueMsgSend;
import com.lzl.aoyama.common.msg.MsgContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/9/8 17:24
 * @Description:
 */
@Component
public class TestProducer extends AbstractMsgProducer {

    @Autowired
    private MessageQueueMsgSend messageQueueMsgSend;

    @Override
    protected void send(MsgContent msgContent) {
        //之所以重载 就是为了看看要不要对方法进行处理
        messageQueueMsgSend.send(msgContent);
    }
}
