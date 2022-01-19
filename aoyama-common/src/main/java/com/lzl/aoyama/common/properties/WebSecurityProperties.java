package com.lzl.aoyama.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lzl
 * @ClassName WebSecurityProperties
 * @date: 2021/4/26 下午4:21
 * @Description:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "auth.client")
public class WebSecurityProperties {

    private String[] permitUrls = {"/"};

    private String[] authenticatedUrls;

}
