package com.lzl.aoyama.gateway.filter;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author lzl
 * @ClassName RouteFilter
 * @date: 2021/5/13 下午1:44
 * @Description:
 */
@Slf4j
@Component
public class RouteFilter implements GlobalFilter, Ordered {

    private final String GRAY_HEADER_KEY = "FACTORY-KEY";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        //只有请求头中带有某个特殊标记，就根据特殊标记修改路由策略
        List<String> headerValues = headers.get(GRAY_HEADER_KEY);
        StringJoiner loadBalancerKey = null;
        if (CollUtil.isNotEmpty(headerValues)) {
            loadBalancerKey = new StringJoiner(";");
            for (String grayValue : headerValues) {
                loadBalancerKey.add(grayValue);
            }
        }
        log.info("loadBalancerKey->>>>>>>>>>>>>{}", loadBalancerKey);
        return  chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
