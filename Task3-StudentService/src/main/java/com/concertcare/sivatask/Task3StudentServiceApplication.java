package com.concertcare.sivatask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Task3StudentServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(Task3StudentServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Task3StudentServiceApplication.class, args);
		logger.info("*****StudentService Application Has Started******");
	}

}
