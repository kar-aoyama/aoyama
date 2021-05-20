package com.lzl.aoyama.sleuth.aoyama.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author lzl
 * @ClassName GetwayApplication
 * @date: 2021/4/21 下午6:00
 * @Description:
 */

/**
 * EnableZuulProxy是EnableZuulServer的超集,
 * 使用EnableZuulServer开启zuul服务时,
 * 会开启一些zuul内置的一些filter,
 * 如果使用EnableZuulProxy开启zuul服务,
 * 会在EnableZuulServer的filter基础上, 额外增加一些其他的filter
 */
//@EnableZuulServer 开启zuul 服务
//@EnableZuulProxy // 开启zuul 代理
@EnableDiscoveryClient //开启服务发现
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }



}
