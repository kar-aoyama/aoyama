package com.lzl.aoyama.sleuth.aoyama.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author lzl
 * @ClassName AbstractResourceServerSsoConfig
 * @date: 2021/5/19 下午3:10
 * @Description:
 */
public abstract class AbstractResourceServerSsoConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private AuthorizationCodeResourceDetails resource;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resource.getClientId());
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().anyRequest().permitAll();
    }
}
