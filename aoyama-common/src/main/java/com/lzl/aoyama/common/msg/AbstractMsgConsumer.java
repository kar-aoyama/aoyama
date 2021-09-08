package com.lzl.aoyama.common.msg;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lzl
 * @ClassName AbstractMsgConsumer
 * @date: 2021/8/23 上午11:09
 * @Description: 抽象消息处理类
 */
@Slf4j
public abstract class AbstractMsgConsumer {


    public abstract void consumer(MsgContent msgContent);
}
