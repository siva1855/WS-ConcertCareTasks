package com.concertcare.sivatask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task2AuthAndNonAuthApIsApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(Task2AuthAndNonAuthApIsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Task2AuthAndNonAuthApIsApplication.class, args);
		logger.info("*****Main Application Has Started******");
	}

}
