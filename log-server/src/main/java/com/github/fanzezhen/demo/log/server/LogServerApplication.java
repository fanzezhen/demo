package com.github.fanzezhen.demo.log.server;

import com.github.fanzezhen.common.core.config.EnableCommonCoreConfig;
import com.github.fanzezhen.common.exception.config.EnableCommonExceptionConfig;
import com.github.fanzezhen.common.log.config.EnableCommonLogConfig;
import com.github.fanzezhen.common.swagger.config.EnableCommonSwaggerConfig;
import com.github.fanzezhen.common.web.config.EnableCommonWebConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zezhen.fan
 */
@EnableCommonLogConfig
@EnableCommonCoreConfig
@EnableCommonExceptionConfig
@EnableCommonSwaggerConfig
@EnableCommonWebConfig
@EnableScheduling
@EnableTransactionManagement
@Slf4j
@EnableSwagger2
@EnableDiscoveryClient
@MapperScan({"com.github.fanzezhen.demo.logbiz.foundation.mapper", "com.github.fanzezhen.common.log.foundation.mapper"})
@EntityScan({"com.github.fanzezhen.demo.logbiz.foundation.entry", "com.github.fanzezhen.common.log.foundation.entity"})
@SpringBootApplication(scanBasePackages = {"com.github.fanzezhen"})
@EnableFeignClients(basePackages = {"com.github.fanzezhen.demo"})
public class LogServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogServerApplication.class, args);
    }

}
