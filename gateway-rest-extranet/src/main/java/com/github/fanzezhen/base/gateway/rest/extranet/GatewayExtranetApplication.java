package com.github.fanzezhen.base.gateway.rest.extranet;

import com.github.fanzezhen.common.gateway.config.EnableGatewayExtranetSpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zezhen.fan
 */
@EnableGatewayExtranetSpringConfig
@SpringBootApplication
public class GatewayExtranetApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayExtranetApplication.class, args);
	}
}
