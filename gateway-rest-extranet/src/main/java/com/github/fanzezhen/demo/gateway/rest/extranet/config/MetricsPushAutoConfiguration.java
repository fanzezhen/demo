package com.github.fanzezhen.demo.gateway.rest.extranet.config;

import io.micrometer.core.instrument.logging.LoggingMeterRegistry;
import io.micrometer.core.instrument.step.StepMeterRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zezhen.fan
 */
@Configuration
@ConditionalOnMissingClass("io.micrometer.influx.InfluxMeterRegistry")
public class MetricsPushAutoConfiguration {

	@Bean
	public StepMeterRegistry loggingMeterRegistry(){
		return new LoggingMeterRegistry();
	}

}
