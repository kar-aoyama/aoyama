package com.lzl.aoyama.pay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lzl
 * @Date 2022/2/7 2:17
 * @Description:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "alibaba")
public class AlibabaConfig {

}
