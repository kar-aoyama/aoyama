package com.lzl.aoyama.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author lzl
 * @ClassName UserApplication
 * @date: 2021/4/26 下午2:59
 * @Description:
 */
@EnableFeignClients
//开启feign客户端
@EnableBinding({Source.class, Sink.class})
//指定包名是为了解决不会扫描common 模块
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.lzl.aoyama")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

    