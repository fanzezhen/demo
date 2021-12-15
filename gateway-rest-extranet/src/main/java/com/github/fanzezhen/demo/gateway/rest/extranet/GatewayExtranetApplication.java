package com.github.fanzezhen.demo.gateway.rest.extranet;

import com.github.fanzezhen.common.core.config.EnableCommonCoreConfig;
import com.github.fanzezhen.common.gateway.config.EnableGatewayExtranetSpringConfig;
import com.github.fanzezhen.common.log.config.EnableCommonLogConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zezhen.fan
 */
@Slf4j
@EnableCommonCoreConfig
@EnableDiscoveryClient
@EnableGatewayExtranetSpringConfig
@SpringBootApplication(scanBasePackages = {"com.github.fanzezhen.demo"}, exclude = {DataSourceAutoConfiguration.class})
public class GatewayExtranetApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayExtranetApplication.class, args);
    }
}
