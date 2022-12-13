package com.my.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/12 18:30
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder  router =  builder.routes();
        router.route("routes_path",
                r -> r.path("/guonei")
                        .uri("https://news.baidu.com/guonei"));
        return router.build();
    }
}
