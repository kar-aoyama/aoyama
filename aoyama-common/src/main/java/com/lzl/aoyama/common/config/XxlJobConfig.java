package com.lzl.aoyama.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author lzl
 * @Date 2022/2/18 16:51
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "xxl-job")
public class XxlJobConfig {


    private String address;

    private String appNmea;

    private String ip;

    private String port;

    private String accessToken;

    private String logPath;

    private String logRetentionDays;

}
