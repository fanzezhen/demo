package com.github.fanzezhen.base.logweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@MapperScan({"com.github.fanzezhen.base.logbiz.foundation.mapper"})
@EntityScan("com.github.fanzezhen.base.logbiz.foundation.entry")
@SpringBootApplication(scanBasePackages = {"com.github.fanzezhen.base"})
@EnableFeignClients(basePackages = {"com.github.fanzezhen.base"})
public class LogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
    }
}
