package com.github.fanzezhen.base.gateway.rest.bench.config;

import com.github.fanzezhen.common.gateway.core.discover.eureka.DiscoverLocatorProperties;
import com.github.fanzezhen.common.gateway.core.discover.provider.route.StaticRouteConfigProvider;
import com.github.fanzezhen.common.gateway.core.tracing.AddTraceHeaderGatewayFilterFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory.REGEXP_KEY;
import static org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory.REPLACEMENT_KEY;
import static org.springframework.cloud.gateway.support.NameUtils.normalizeFilterFactoryName;

public class SimpleRouteConfigProvider extends StaticRouteConfigProvider {


	public SimpleRouteConfigProvider(DiscoverLocatorProperties properties, List<GatewayFilterFactory> gatewayFilterFactories) {
		super(properties, gatewayFilterFactories);
	}

	@Override
	protected List<FilterDefinition> doGetDefaultFilterChain(ServiceInstance instance,
															 String routeId,
															 boolean checkExtranetSign) {
		ArrayList<FilterDefinition> definitions = new ArrayList<>();

		// add a rewrite that removes /serviceId by default
		FilterDefinition rewrite = new FilterDefinition();
		rewrite.setName(normalizeFilterFactoryName(RewritePathGatewayFilterFactory.class));
		String regex = "'/' + serviceId + '/(?<remaining>.*)'";
		String replacement = "'/${remaining}'";
		rewrite.addArg(REGEXP_KEY, regex);
		rewrite.addArg(REPLACEMENT_KEY, replacement);
		definitions.add(rewrite);

		FilterDefinition trace = new FilterDefinition();
		trace.setName(normalizeFilterFactoryName(AddTraceHeaderGatewayFilterFactory.class));
		definitions.add(trace);

//		FilterDefinition security = new FilterDefinition();
//		security.setName(normalizeFilterFactoryName(SecureHeadersGatewayFilterFactory.class));
//		definitions.add(security);

//		FilterDefinition rate = new FilterDefinition();
//		rate.setName(normalizeFilterFactoryName(RequestRateLimiterGatewayFilterFactory.class));
//
//		rate.addArg("redis-rate-limiter.replenishRate", "1");
//		rate.addArg("redis-rate-limiter.burstCapacity", "1");
//		rate.addArg("keyResolver", "'#{@userIdResolver}'");
//		rate.addArg("denyEmptyKey","false");
//		definitions.add(rate);




		return definitions;
	}

}
