package com.lzl.aoyama.auth.config;

import com.lzl.aoyama.auth.handler.UserDetailServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.KeyPair;

/**
 * @author lzl
 * @ClassName AuthorizationServerConfig
 * @date: 2021/5/14 下午3:29
 * @Description: 认证资源服务器配置
 */
@Component
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig implements AuthorizationServerConfigurer {

    @Autowired
    private DataSource dataSource;
    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    @Qualifier(value = "accessTokenConverter")
    private AccessTokenConverter accessTokenConverter;

    //AuthorizationServerEndpointsConfigurer：用来配置授权
    // （authorization）以及令牌（token）的访问端点和令牌服务(token services)。
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("isAuthenticated()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()");
    }

    //用来配置客户端详情服务 ClientDetailsService
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //注入数据源
        clients.jdbc(dataSource);
    }

    //用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.
                accessTokenConverter(accessTokenConverter).
                userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager);
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(
                new ClassPathResource("lzl-jwt.jks"),
                "lzl0502".toCharArray()
        ).getKeyPair("lzl-jwt");
        jwtAccessTokenConverter.setKeyPair(keyPair);
        return jwtAccessTokenConverter;
    }
}
