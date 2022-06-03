package com.lzl.aoyama;

import com.lzl.aoyama.auth.AuthApplication;
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
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void method() {
        BoundHashOperations map = redisTemplate.boundHashOps("map");
        map.put("123","顶你个肺");
        System.out.println(map.get("123"));
    }

}
