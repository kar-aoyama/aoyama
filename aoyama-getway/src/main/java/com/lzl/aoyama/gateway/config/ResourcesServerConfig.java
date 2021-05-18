package com.lzl.aoyama.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author lzl
 * @ClassName ResouecesConfig
 * @date: 2021/4/21 下午6:13
 * @Description:
 */
@EnableResourceServer
public class ResourcesServerConfig extends ResourceServerConfigurerAdapter {

    @Value("spring.security.oauth2.client.client-Id")
    private String clientId;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(clientId);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll();
    }
}
