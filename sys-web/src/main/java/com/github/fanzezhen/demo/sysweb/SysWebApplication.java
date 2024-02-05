package com.github.fanzezhen.demo.sysweb;

import com.github.fanzezhen.common.log.config.EnableCommonLogConfig;
import com.github.fanzezhen.common.core.config.EnableCoreConfig;
import com.github.fanzezhen.common.security.config.cas.EnableCommonSecurityCasConfig;
import com.github.fanzezhen.common.swagger.config.EnableCommonSwaggerConfig;
import com.github.fanzezhen.common.web.config.EnableCommonWebConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @author zezhen.fan
 */
@EnableCommonLogConfig
@EnableCoreConfig
@EnableCommonSecurityCasConfig
@EnableCommonSwaggerConfig
@EnableCommonWebConfig
@EnableScheduling
@EnableTransactionManagement
@Slf4j
@EnableDiscoveryClient
@MapperScan({"com.github.fanzezhen.demo.sysbiz.foundation.mapper", "com.github.fanzezhen.common.*.foundation.mapper"})
@EntityScan({"com.github.fanzezhen.demo.sysbiz.foundation.entry", "com.github.fanzezhen.common.*.foundation.entity"})
@SpringBootApplication(scanBasePackages = {"com.github.fanzezhen.demo"})
@EnableFeignClients(basePackages = {"com.github.fanzezhen.demo"})
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class SysWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysWebApplication.class, args);
    }

    /**
     * 启用负载均衡，默认算法是轮询
     *
     * @return restTemplate
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
