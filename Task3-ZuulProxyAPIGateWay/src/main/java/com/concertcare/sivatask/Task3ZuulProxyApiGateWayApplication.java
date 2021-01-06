package com.concertcare.sivatask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class Task3ZuulProxyApiGateWayApplication {
	private static final Logger logger = LoggerFactory.getLogger(Task3ZuulProxyApiGateWayApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Task3ZuulProxyApiGateWayApplication.class, args);
		logger.info("*****ZuulProxy APIGateway Application Has Started******");
	}

}
