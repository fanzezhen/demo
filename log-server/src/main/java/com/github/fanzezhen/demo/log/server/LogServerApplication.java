package com.github.fanzezhen.demo.log.server;

import com.github.fanzezhen.common.all.EnableAllConfig;
import com.github.fanzezhen.common.core.config.EnableCoreConfig;
import com.github.fanzezhen.common.exception.config.EnableCommonExceptionConfig;
import com.github.fanzezhen.common.swagger.config.EnableCommonSwaggerConfig;
import com.github.fanzezhen.common.web.config.EnableCommonWebConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author zezhen.fan
 */
@EnableWebMvc
@EnableAllConfig
@EnableCommonExceptionConfig
@EnableCommonSwaggerConfig
@EnableCommonWebConfig
@EnableScheduling
@EnableTransactionManagement
@Slf4j
@EnableDiscoveryClient
@MapperScan({"com.github.fanzezhen.demo.logbiz.foundation.mapper", "com.github.fanzezhen.common.log.foundation.mapper"})
@EntityScan({"com.github.fanzezhen.demo.logbiz.foundation.entry", "com.github.fanzezhen.common.log.foundation.entity"})
@SpringBootApplication(scanBasePackages = {"com.github.fanzezhen.demo"})
public class LogServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogServerApplication.class, args);
    }

}
