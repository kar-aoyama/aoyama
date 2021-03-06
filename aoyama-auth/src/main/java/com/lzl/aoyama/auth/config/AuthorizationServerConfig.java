package com.lzl.aoyama.auth.config;

import com.lzl.aoyama.common.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.security.KeyPair;

/**
 * @author lzl
 * @ClassName AuthorizationServerConfig
 * @date: 2021/5/14 ??????3:29
 * @Description: ???????????????????????????
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    SecurityFilterChain securityFilterChain;
    @Autowired
    private DataSource dataSource;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Qualifier("userDetailServiceHandler")
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    @Qualifier(value = "jwtAccessTokenConverter")
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    //AuthorizationServerEndpointsConfigurer?????????????????????
    // ???authorization??????????????????token?????????????????????????????????(token services)???
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // ??????/oauth/token_key???????????????????????????
                .tokenKeyAccess("isAuthenticated()")
                // ??????/oauth/check_token??????????????????????????????
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    //????????????????????????????????? ClientDetailsService
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //???????????????
        clients.withClientDetails(clientDetails());
    }

    //?????????????????????????????????
    @Bean
    public ClientDetailsService clientDetails() {
        JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(dataSource);
        jdbcClientDetailsService.setPasswordEncoder(passwordEncoder);
        return jdbcClientDetailsService;
    }

    //?????????????????????authorization??????????????????token?????????????????????????????????(token services)???
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
       /* TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();
        tokenEnhancers.add(tokenEnhancer());
        tokenEnhancers.add(jwtAccessTokenConverter);
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);

        DefaultTokenServices tokenServices =
                (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        endpoints.tokenServices(tokenServices);

        endpoints.authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(tokenEnhancerChain)
                .userDetailsService(userDetailsService)
                // refresh_token????????????????????????????????????(true)??????????????????(false)????????????true
                //      1.???????????????access_token?????????????????? refresh token?????????????????????????????????????????????????????????
                //      2.??????????????????access_token?????????????????? refresh_token????????????????????????refresh_token?????????????????????????????????????????????
                .reuseRefreshTokens(false);*/
        endpoints
                //?????????????????????
                .authenticationManager(authenticationManager)
                //??????????????????????????????
                .exceptionTranslator(e -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR))
                //????????????????????????
                .userDetailsService(userDetailsService)
                //?????? token ???????????????
                .tokenStore(jwtTokenStore())
                //token????????????
                .accessTokenConverter(jwtAccessTokenConverter());
        DefaultTokenServices tokenServices
                = (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());

    }

    private WebResponseExceptionTranslator<OAuth2Exception> exceptionTranslator() {
        return e -> {
            if (e instanceof InvalidGrantException) {
                GlobalException globalException =
                        GlobalException.newInstance("??????????????????");

                OAuth2Exception oAuth2Exception = new OAuth2Exception("??????????????????", globalException);
                return new ResponseEntity<>(oAuth2Exception, HttpStatus.OK);
            }
            return null;
        };
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(
                new ClassPathResource("lzl-jwt.jks"),
                "lzl0502".toCharArray()
        ).getKeyPair("lzl-jwt");
        jwtAccessTokenConverter.setKeyPair(keyPair);
        return jwtAccessTokenConverter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
}
