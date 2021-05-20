package com.lzl.aoyama.gateway.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.server.SecurityWebFilterChain;


/**
 * @author lzl
 * @ClassName ResourceServerConfig
 * @date: 2021/4/14 下午2:53
 * @Description:
 */
@Slf4j
//@EnableResourceServer 在gateway webFlux 不能使用
@EnableWebFluxSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /*@Autowired
    ExpressionHandler expressionHandler;*/


   /* @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("oauth2");
        //无权访问
        log.info("无权访问");
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest()
               .permitAll() //.access("#verifyPermissions.hasPermission(request,authentication)")
                .and()
                .csrf()
                .disable()
                .cors()
                .disable();

        // http.addFilterBefore(new MyAuthenticationFilter(), LogoutFilter.class);
    }*/


    @Bean
    SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {
        http
//                .authenticationManager(myReactiveAuthenticationManager)//自定义登录验证。自动扫描注入，无需手动注入
                .authorizeExchange()
                .anyExchange()
                .permitAll()  //无需进行权限过滤的请求路径
                .and()
//                .authorizeExchange().pathMatchers("/**")
//                .access(myRBACServiceWebFlux)//自定义的鉴权服务，通过鉴权的才能继续访问某个请求
//                .anyExchange().authenticated()
//                .and()
                .httpBasic()
                .and()
                .formLogin()
                .loginPage("/auth/login")//指定登录请求路径
//                .authenticationSuccessHandler(loginSuccessHandlerWebFlux) //认证成功
//                .authenticationFailureHandler(loginFailedHandlerWebFlux) //登陆验证失败
//                .and().exceptionHandling().authenticationEntryPoint(customHttpBasicServerAuthenticationEntryPoint)  //未登录访问资源时的处理类，若无此处理类，前端页面会弹出登录窗口
//                .and().exceptionHandling().accessDeniedHandler(myAccessDeniedHandlerWebFlux)//访问被拒绝时自定义处理器
                .and()
                .csrf()
                .disable()//必须支持跨域
                .cors()
                .disable()
                .logout().logoutUrl("/auth/logout");

        return http.build();

    }
}
