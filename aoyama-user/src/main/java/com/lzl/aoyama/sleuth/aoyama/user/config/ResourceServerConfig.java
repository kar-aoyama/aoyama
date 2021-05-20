package com.lzl.aoyama.sleuth.aoyama.user.config;

import com.lzl.aoyama.sleuth.aoyama.common.config.AbstractResourceServerSsoConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author lzl
 * @ClassName ResourceServerConfig
 * @date: 2021/5/19 下午3:22
 * @Description:
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends AbstractResourceServerSsoConfig { }
