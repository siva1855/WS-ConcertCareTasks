package com.concertcare.sivatask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Task3EurekaServiceRegistryApplication {

	private static final Logger logger = LoggerFactory.getLogger(Task3EurekaServiceRegistryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Task3EurekaServiceRegistryApplication.class, args);
		logger.info("*****Eureka Service Registry Application Has Started******");
	}

}
