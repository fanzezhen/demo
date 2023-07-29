package com.github.fanzezhen.demo.gateway.rest.bench;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义网关路由配置
 *
 * @author zezhen.fan
 * @date 2023/7/28
 */
@Configuration
public class RouteLocatorConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocator) {
        RouteLocatorBuilder.Builder routes = routeLocator.routes();
        //说明：访问localhost:9527/guonei地址会转发到http://news.baidu.com/guonei地址
        //  //lb: 请求地址中必须包含lb.filters(f->f.stripPrefix(1)) //去掉第一个路径.uri("lb://cloud-payment-service") //lb: 负载均衡指向地址)
        return routes
                //说明：访问localhost:9527/guonei地址会转发到http://news.baidu.com/guonei地址
                .route("path_route1", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                //lb: 请求地址中必须包含lb
                .route(p -> p.path("/lb/**")
                        //去掉第一个路径
                        .filters(f -> f.stripPrefix(1))
                        //http://localhost:8080/lb/log/operation/test
                        .uri("lb://demo-log-server")
                )
                .build();
    }
}