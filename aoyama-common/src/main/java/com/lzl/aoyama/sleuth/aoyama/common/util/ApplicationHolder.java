package com.lzl.aoyama.sleuth.aoyama.common.util;

import com.lzl.aoyama.sleuth.aoyama.common.annotation.PermissionCheck;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lzl
 * @ClassName ApplicationHodler
 * @date: 2021/4/26 下午3:37
 * @Description:  ApplicationContext 工具类
 */
@Component
public class ApplicationHolder implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationHolder.applicationContext == null)
            ApplicationHolder.applicationContext = applicationContext;
    }



    /**
     * 默认没注解则算要权限(不要权限的比较少)
     *
     * @return
     */
    public static Set<RequestMappingInfo> getNoAuthorizedUrls() {
        Set<RequestMappingInfo> urls = new HashSet<>(256);
        Map<String, RequestMappingHandlerMapping> requestMappingHandlerMappingMap =
                applicationContext.getBeansOfType(RequestMappingHandlerMapping.class);
        for (RequestMappingHandlerMapping handlerMapping : requestMappingHandlerMappingMap.values()) {
            Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();

            for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
                RequestMappingInfo requestMappingInfo = entry.getKey();
                HandlerMethod method = entry.getValue();
                if (method.hasMethodAnnotation(PermissionCheck.class)) {
                    PermissionCheck permissionCheck = method.getMethodAnnotation(PermissionCheck.class);
                    if (!permissionCheck.required()) {
                        urls.add(requestMappingInfo);
                        continue;
                    }
                }
                if (method.getBeanType().isAnnotationPresent(PermissionCheck.class)) {
                    PermissionCheck permissionCheck = method.getBeanType().getAnnotation(PermissionCheck.class);
                    if (!permissionCheck.required()) {
                        urls.add(requestMappingInfo);
                    }
                }
            }
        }
        return urls;
    }






}
