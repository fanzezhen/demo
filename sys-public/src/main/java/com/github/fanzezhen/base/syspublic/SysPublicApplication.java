package com.github.fanzezhen.base.syspublic;

import com.github.fanzezhen.common.core.config.EnableCommonCoreConfig;
import com.github.fanzezhen.common.mp.config.EnableCommonMpConfig;
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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zezhen.fan
 */
@EnableCommonMpConfig
@EnableCommonSwaggerConfig
@EnableCommonWebConfig
@EnableScheduling
@EnableTransactionManagement
@Slf4j
@EnableSwagger2
@EnableDiscoveryClient
@MapperScan({"com.github.fanzezhen.base.sysbiz.foundation.mapper"})
@EntityScan("com.github.fanzezhen.base.sysbiz.foundation.entry")
@SpringBootApplication(scanBasePackages = {"com.github.fanzezhen.base"},
        exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@EnableFeignClients(basePackages = {"com.github.fanzezhen.base"})
public class SysPublicApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysPublicApplication.class, args);
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
