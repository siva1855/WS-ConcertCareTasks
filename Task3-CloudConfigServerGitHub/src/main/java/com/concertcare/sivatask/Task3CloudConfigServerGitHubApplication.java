package com.concertcare.sivatask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class Task3CloudConfigServerGitHubApplication {

	private static final Logger logger = LoggerFactory.getLogger(Task3CloudConfigServerGitHubApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Task3CloudConfigServerGitHubApplication.class, args);
		logger.info("*****Cloud Config Server Application Has Started******");
	}

}
