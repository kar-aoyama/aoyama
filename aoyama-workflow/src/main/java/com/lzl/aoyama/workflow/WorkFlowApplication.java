package com.lzl.aoyama.workflow;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lzl
 * @ClassName WorkFlowApplication
 * @date: 2021/7/23 下午3:59
 * @Description:
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.lzl.aoyama",exclude = SecurityAutoConfiguration.class)
public class WorkFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkFlowApplication.class, args);
    }
}
