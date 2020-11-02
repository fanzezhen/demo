package com.github.fanzezhen.base.sysweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zezhen.fan
 */
@EnableDiscoveryClient
@MapperScan({"com.github.fanzezhen.base.sysbiz.foundation.mapper"})
@EntityScan("com.github.fanzezhen.base.sysbiz.foundation.entry")
@SpringBootApplication(scanBasePackages = {"com.github.fanzezhen.base", "com.github.fanzezhen.common"})
@EnableFeignClients(basePackages = {"com.github.fanzezhen.base"})
public class SysApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
    }

}
