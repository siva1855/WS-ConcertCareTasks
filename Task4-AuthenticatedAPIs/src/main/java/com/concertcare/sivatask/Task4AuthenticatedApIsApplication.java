package com.concertcare.sivatask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task4AuthenticatedApIsApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(Task4AuthenticatedApIsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Task4AuthenticatedApIsApplication.class, args);
		logger.info("*****Main Application Has Started******");
	}

}
