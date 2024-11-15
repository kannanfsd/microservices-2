package com.easyfund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator easyFundRouteConfig(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/easyfund/accounts/**")
						.filters(f -> f.rewritePath("/easyfund/accounts/(?<segment>.*)", "/${segment}")
						.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://ACCOUNTS"))
				.route(p -> p.path("/easyfund/loans/**")
						.filters(f -> f.rewritePath("/easyfund/loans/(?<segment>.*)", "/${segment}")
						.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://LOANS"))
				.route(p -> p.path("/easyfund/cards/**")
						.filters(f -> f.rewritePath("/easyfund/cards/(?<segment>.*)", "/${segment}")
						.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://CARDS")).build();
	}

}
