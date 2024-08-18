package com.infybuzz.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		Logger logger = LoggerFactory.getLogger(CustomFilter.class);
		
		ServerHttpRequest httpRequest =exchange.getRequest();
		logger.info("Authorization"+ httpRequest.getHeaders().getFirst("Authorization"));
		return chain.filter(exchange).then(Mono.fromRunnable(()-> {
			//before API Gateway passes response to Consumer
			//POst Filter
			ServerHttpResponse httpResponse = exchange.getResponse();
			
			logger.info("Post Filter: "+httpResponse.getStatusCode());
		}));
				
	}
}