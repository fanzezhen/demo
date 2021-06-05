package com.github.fanzezhen.base.gateway.rest.intranet;

import com.github.fanzezhen.common.gateway.config.EnableGatewayIntranetSpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zezhen.fan
 */
@EnableGatewayIntranetSpringConfig
@SpringBootApplication
public class GatewayIntranetApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayIntranetApplication.class, args);
	}
}
