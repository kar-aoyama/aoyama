package com.lzl.aoyama.common.msg.annotation;

import com.lzl.aoyama.common.msg.AbstractMsgProducer;
import com.lzl.aoyama.common.msg.MessageQueueMsgSend;

import java.lang.annotation.*;

/**
 * @author simba@onlying.cn
 * @date 2021/9/8 17:36
 * @Description:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableMsgProducer {

    Class<? extends MessageQueueMsgSend> value();


    Class<? extends AbstractMsgProducer> producer();


}
