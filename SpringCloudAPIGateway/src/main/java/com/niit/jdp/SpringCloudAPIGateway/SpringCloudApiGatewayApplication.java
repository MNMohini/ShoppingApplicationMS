package com.niit.jdp.SpringCloudAPIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SpringCloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/api/v1/**").uri("lb://customer-service"))
				.route(p -> p.path("/api/v2/**").uri("lb://restservice"))
				.build();
	}
}
