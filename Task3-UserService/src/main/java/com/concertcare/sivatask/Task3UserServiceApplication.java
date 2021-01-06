package com.concertcare.sivatask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class Task3UserServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(Task3UserServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Task3UserServiceApplication.class, args);
		logger.info("*****UserService Application Has Started******");
	}

}
