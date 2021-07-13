/*
package com.lzl.aoyama.gateway.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

*/
/**
 * @author lzl
 * @ClassName ExpressionHandler
 * @date: 2021/4/14 下午3:42
 * @Description:
 *//*

@Component
public class ExpressionHandler extends OAuth2WebSecurityExpressionHandler {

    @Autowired
    private VerifyPermissionsHandler verifyPermissionsHandler;

    @Override
    protected StandardEvaluationContext createEvaluationContextInternal(Authentication authentication, FilterInvocation invocation) {
        StandardEvaluationContext ex = super.createEvaluationContextInternal(authentication, invocation);
        //注入表达式
        //使用 #verifyPermissions.method()
        ex.setVariable("verifyPermissions", verifyPermissionsHandler);
        return ex;
    }
}
*/
