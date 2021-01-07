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
public class Task3ConsumerUserServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(Task3ConsumerUserServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Task3ConsumerUserServiceApplication.class, args);
		
		logger.info("*****ConsumerUserService Application Has Started******");
	}

}
