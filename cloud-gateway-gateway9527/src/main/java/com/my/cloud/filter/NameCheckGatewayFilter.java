package com.my.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/12 20:46
 */
@Component
@Slf4j
public class NameCheckGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null){
            log.info("username值为空");
            exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
            return exchange.getResponse().setComplete();
        }
        log.info("当前username参数:{}",username);
        //放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
