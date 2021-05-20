package com.lzl.aoyama.auth.config;


import com.lzl.aoyama.common.util.ApplicationHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.util.Set;

/**
 * @author lzl
 * @ClassName WebSecurityConfig
 * @date: 2021/4/26 下午2:47
 * @Description:
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailServiceHandler")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
        auth.authenticationProvider(createAuthenticationProvider());
    }


    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/assets/**", "/*.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        Set<RequestMappingInfo> noAuthorizedRequestMappingInfo = ApplicationHolder.getNoAuthorizedUrls();
        for (RequestMappingInfo mappingInfo : noAuthorizedRequestMappingInfo) {
            Set<String> patterns = mappingInfo.getPatternsCondition().getPatterns();
            Set<RequestMethod> methods = mappingInfo.getMethodsCondition().getMethods();
            for (RequestMethod method : methods) {
                //防止同名方法  请求方式不同
                http.authorizeRequests().antMatchers(
                        HttpMethod.resolve(method.name()),
                        patterns.toArray(new String[]{}))
                        .permitAll();
            }
        }
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .and()
                .cors()
                .disable().csrf().disable()
                .sessionManagement()
                .maximumSessions(1);

    }

    @Bean
    public DaoAuthenticationProvider createAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        return daoAuthenticationProvider;
    }


    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //如果您使用的是grant_type =password，则必须：
    //在自己的WebSecurityConfigurerAdapter类中创建以下bean
    //然后再AuthorizationServerConfigurer 实现类令牌端点使用
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
