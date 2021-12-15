package com.github.fanzezhen.demo.gateway.rest.bench.config;

import com.github.fanzezhen.common.gateway.core.discover.choose.Chooser;
import com.github.fanzezhen.common.gateway.core.discover.eureka.DiscoverLocatorProperties;
import com.github.fanzezhen.common.gateway.core.discover.provider.route.RouteConfigProvider;
import com.github.fanzezhen.common.gateway.core.filter.ignore.IgnoreProperties;
import com.github.fanzezhen.common.gateway.core.rate.limit.UserIdResolver;
import com.github.fanzezhen.common.gateway.core.support.error.GlobalErrorWebExceptionHandler;
import com.github.fanzezhen.common.gateway.core.discover.choose.AlwaysTrueChooser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.validation.Validator;

import java.util.List;


@Configuration
public class RestAutoConfiguration {

	private final ApplicationContext applicationContext;

	private final ResourceProperties resourceProperties;

	private final ServerCodecConfigurer serverCodecConfigurer;

	public RestAutoConfiguration(ApplicationContext applicationContext, ResourceProperties resourceProperties, ServerCodecConfigurer serverCodecConfigurer) {
		this.applicationContext = applicationContext;
		this.resourceProperties = resourceProperties;
		this.serverCodecConfigurer = serverCodecConfigurer;
	}

	@Bean
	public Chooser chooser() {
		return new AlwaysTrueChooser();
	}

	@Bean
	public IgnoreProperties ignoreProperties() {
		return new IgnoreProperties();
	}

	@Bean
	@DependsOn({"discoverLocatorProperties"})
	@ConditionalOnBean(DiscoverLocatorProperties.class)
	public RouteConfigProvider routeConfigProvider(DiscoverLocatorProperties discoverLocatorProperties,
	                                               List<GatewayFilterFactory> gatewayFilters) {
		return new SimpleRouteConfigProvider(discoverLocatorProperties, gatewayFilters);
	}

	@Bean
	@Primary
	@DependsOn({"reactiveRedisConnectionFactory"})
	@ConditionalOnBean(ReactiveRedisConnectionFactory.class)
	public ReactiveStringRedisTemplate reactiveStringRedisTemplate(
			ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
		RedisSerializer<String> serializer = new StringRedisSerializer();
		RedisSerializationContext<String, String> serializationContext = RedisSerializationContext
				.<String, String>newSerializationContext().key(serializer)
				.value(serializer).hashKey(serializer).hashValue(serializer).build();
		return new ReactiveStringRedisTemplate(reactiveRedisConnectionFactory,
				serializationContext);
	}

	@Bean(name = "userIdResolver")
	public UserIdResolver userIdResolver() {
		return new UserIdResolver();
	}

	@Bean
	@SuppressWarnings("unchecked")
	public RedisScript redisRequestRateLimiterScript() {
		DefaultRedisScript redisScript = new DefaultRedisScript<>();
		redisScript.setScriptSource(new ResourceScriptSource(
				new ClassPathResource("META-INF/scripts/request_rate_limiter.lua")));
		redisScript.setResultType(List.class);
		return redisScript;
	}

	@Bean
	@ConditionalOnMissingBean
	@DependsOn({"validator"})
	@ConditionalOnBean(Validator.class)
	public RedisRateLimiter redisRateLimiter(
			ReactiveStringRedisTemplate redisTemplate,
			@Qualifier(RedisRateLimiter.REDIS_SCRIPT_NAME) RedisScript<List<Long>> redisScript,
			Validator validator) {
		return new RedisRateLimiter(redisTemplate, redisScript, validator);
	}

	@Bean
	@Order(-2)
	@DependsOn({"errorAttributes"})
	@ConditionalOnBean(ErrorAttributes.class)
	public GlobalErrorWebExceptionHandler globalErrorWebExceptionHandler(ErrorAttributes errorAttributes) {
		GlobalErrorWebExceptionHandler exceptionHandler = new GlobalErrorWebExceptionHandler(errorAttributes, resourceProperties, applicationContext);
		exceptionHandler.setMessageWriters(this.serverCodecConfigurer.getWriters());
		exceptionHandler.setMessageReaders(this.serverCodecConfigurer.getReaders());
		return exceptionHandler;
	}

}
