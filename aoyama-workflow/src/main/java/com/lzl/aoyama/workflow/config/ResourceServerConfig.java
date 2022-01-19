package com.lzl.aoyama.workflow.config;

import com.lzl.aoyama.common.config.AbstractResourceServerSsoConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author lzl
 * @ClassName ResourceConfig
 * @date: 2021/7/23 下午4:23
 * @Description:
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends AbstractResourceServerSsoConfig {
}
