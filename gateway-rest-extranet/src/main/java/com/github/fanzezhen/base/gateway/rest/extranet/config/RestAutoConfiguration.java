package com.github.fanzezhen.base.gateway.rest.extranet.config;

import com.github.fanzezhen.common.gateway.core.discover.eureka.DiscoverLocatorProperties;
import com.github.fanzezhen.common.gateway.core.discover.provider.route.RouteConfigProvider;
import com.github.fanzezhen.common.gateway.core.discover.provider.route.StaticRouteConfigProvider;
import com.github.fanzezhen.common.gateway.core.filter.auth.AuthProperties;
import com.github.fanzezhen.common.gateway.core.filter.auth.factory.csp.CspTokenGatewayFilterFactory;
import com.github.fanzezhen.common.gateway.core.filter.auth.factory.csp.FaqTokenGatewayFilterFactory;
import com.github.fanzezhen.common.gateway.core.filter.ignore.IgnoreProperties;
import com.github.fanzezhen.common.gateway.core.filter.ignore.TokenIgnoreGatewayFilterFactory;
import com.github.fanzezhen.common.gateway.core.metrics.DefaultExcludeMeterFilter;
import com.github.fanzezhen.common.gateway.core.metrics.NettyAllocatorMetrics;
import com.github.fanzezhen.common.gateway.core.support.error.GlobalErrorWebExceptionHandler;
import com.github.fanzezhen.common.gateway.extranet.AddSignHeaderAndChangeRequestUriFactory;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.codec.ServerCodecConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zezhen.fan
 */
@Configuration
public class RestAutoConfiguration {
    @Resource
    private ApplicationContext applicationContext;
    @Resource
    private ResourceProperties resourceProperties;
    @Resource
    private DiscoverLocatorProperties discoverLocatorProperties;
    @Resource
    private ServerCodecConfigurer serverCodecConfigurer;


    @Bean
    public IgnoreProperties ignoreProperties() {
        return new IgnoreProperties();
    }

    @Bean
    public TokenIgnoreGatewayFilterFactory.DefinitionBuilder tokenDefinitionBuilder() {
        return new TokenIgnoreGatewayFilterFactory.DefinitionBuilder();
    }

    @Bean
    public TokenIgnoreGatewayFilterFactory tokenIgnoreGatewayFilterFactory() {
        return new TokenIgnoreGatewayFilterFactory();
    }

    @Bean
    public AuthProperties authProperties() {
        return new AuthProperties();
    }

    @Bean
    public CspTokenGatewayFilterFactory cspTokenGatewayFilterFactory(ReactiveStringRedisTemplate reactiveStringRedisTemplate,
                                                                     AuthProperties authProperties) {
        return new CspTokenGatewayFilterFactory(reactiveStringRedisTemplate, authProperties);
    }

    @Bean
    public FaqTokenGatewayFilterFactory faqTokenGatewayFilterFactory(ReactiveStringRedisTemplate reactiveStringRedisTemplate) {
        return new FaqTokenGatewayFilterFactory(reactiveStringRedisTemplate);
    }

    @Bean
    public AddSignHeaderAndChangeRequestUriFactory addSignHeaderAndChangeRequestUriFactory() {
        return new AddSignHeaderAndChangeRequestUriFactory(discoverLocatorProperties);
    }

    //--------------global------------------//

    @Bean
    @Primary
    public ReactiveStringRedisTemplate reactiveStringRedisTemplate(
            ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
        RedisSerializer<String> serializer = new StringRedisSerializer();
        RedisSerializationContext<String, String> serializationContext = RedisSerializationContext
                .<String, String>newSerializationContext().key(serializer)
                .value(serializer).hashKey(serializer).hashValue(serializer).build();
        return new ReactiveStringRedisTemplate(reactiveRedisConnectionFactory,
                serializationContext);
    }

    @Bean
    @Order(-2)
    public GlobalErrorWebExceptionHandler globalErrorWebExceptionHandler(ErrorAttributes errorAttributes) {
        GlobalErrorWebExceptionHandler exceptionHandler = new GlobalErrorWebExceptionHandler(errorAttributes, resourceProperties, applicationContext);
        exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
        exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
        return exceptionHandler;
    }


    @Bean
    public RouteConfigProvider routeConfigProvider(DiscoverLocatorProperties discoverLocatorProperties,
                                                   List<GatewayFilterFactory> gatewayFilters) {
        return new StaticRouteConfigProvider(discoverLocatorProperties, gatewayFilters);
    }

    @Bean
    public NettyAllocatorMetrics nettyAllocatorMetrics() {
        return new NettyAllocatorMetrics();
    }


    @Bean
    public DefaultExcludeMeterFilter defaultExcludeMeterFilter() {
        ArrayList<String> toExclude = new ArrayList<>();
        toExclude.add("logback");
        toExclude.add("jvm.buffer");
        return new DefaultExcludeMeterFilter(toExclude);
    }
}
