package com.lzl.aoyama.common.msg;

/**
 * @author lzl
 * @ClassName AbstractMsgProducer
 * @date: 2021/8/23 上午11:08
 * @Description:  抽象消息发送类
 */
public abstract class AbstractMsgProducer {

    protected abstract void send(MsgContent msgContent);
}
