package com.lzl.aoyama.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lzl
 * @ClassName AuthApplication
 * @date: 2021/4/21 下午6:15
 * @Description:
 */
// 开启服务注册发现
@EnableDiscoveryClient
//开启feign客户端
@EnableFeignClients
//指定包名是为了解决不会扫描common 模块
@SpringBootApplication(scanBasePackages = "com.lzl.aoyama"
        //排除掉 不然seata不生效
        //,exclude = {DataSourceAutoConfiguration.class}
)
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
