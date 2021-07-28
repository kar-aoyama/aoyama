package com.lzl.aoyama.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzl
 * @ClassName RedisConfig
 * @date: 2021/5/21 下午2:59
 * @Description:
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        //单机版
        config.useSingleServer()
                .setAddress("redis://81.68.170.150:6379").setPassword("lzl0502");

        return Redisson.create(config);
    }

    @Bean
    RedissonConnectionFactory redissonConnectionFactory(RedissonClient redissonClient) {
        return new RedissonConnectionFactory(redissonClient);
    }
}
