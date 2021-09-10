package com.lzl.aoyama;

import com.google.common.collect.Maps;
import com.lzl.aoyama.auth.AuthApplication;
import com.lzl.aoyama.common.msg.MsgContent;
import com.lzl.aoyama.common.util.UUidUtil;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @author simba@onlying.cn
 * @date 2021/9/10 10:04
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class)
@EnableDiscoveryClient
@EnableBinding({Source.class})
@ComponentScan(basePackages = "com.lzl")
public class AuthSpringTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${spring.datasource.url}")
    private String url;

    @Autowired
    private MessageChannel output;

    @Autowired
    private Source source;


    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void method() {
        MsgContent msgContent = new MsgContent();
        msgContent.setContent("你好啊");
        msgContent.setTo(new String[]{"111"});
        msgContent.setId(UUidUtil.uid());
        Message<MsgContent> message = createMessage(msgContent);
        source.output().send(message);
    }

    public Message<MsgContent> createMessage(MsgContent msgContent) {
        Map<String, Object> headersMap = Maps.newHashMap();
        //设置广播模式
        //  headersMap.put(MsgTagConst.TAGS, msgContent.isBroadCast() ? MsgTagConst.BROADCAST_TAG : MsgTagConst.CLUSTER_TAG);
        MessageHeaders messageHeaders = new MessageHeaders(headersMap);
        return MessageBuilder.createMessage(msgContent, messageHeaders);
    }
}
