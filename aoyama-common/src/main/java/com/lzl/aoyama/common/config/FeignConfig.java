package com.lzl.aoyama.common.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author lzl
 * @ClassName FeignConfig
 * @date: 2021/5/18 下午1:25
 * @Description: 因为 Feign 默认下，不转发 Authorization 的相关的信息 Basic Authenticate 信息丢失
 * https://www.shangyang.me/2017/06/01/spring-cloud-oauth2-zuul-potholes/
 * https://blog.csdn.net/AaronSimon/article/details/82711036
 */
@Slf4j
@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes == null) {
                return;
            }
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            //解决feign 丢失请求头信息
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                Enumeration<String> headerValues = request.getHeaders(headerName);
                while (headerValues.hasMoreElements()) {
                    String headerValue = headerValues.nextElement();

                    if (headerName.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH)){
                        continue;
                    }
                    template.header(headerName, headerValue);
                }
            }

            //设置认证信息
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof OAuth2Authentication) {
                OAuth2AuthenticationDetails details =
                        (OAuth2AuthenticationDetails) authentication.getDetails();
                String tokenType = details.getTokenType();
                String tokenValue = details.getTokenValue();
                template.header("Authorization", tokenType + " " + tokenValue);
            }

//            //设置分布式事务xid
//            String xid = RootContext.getXID();
//            if (StrUtil.isNotBlank(xid)) {
//                template.header(RootContext.KEY_XID, xid);
//                log.info("分布式事务id：{}", xid);
//            }

        };
    }
}
