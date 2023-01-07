package com.medicalServiceSystem.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionMicroServiceApplication {
	// static Logger logger =
	// LogManager.getLogger(TransactionMicroServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TransactionMicroServiceApplication.class, args);
		// logger.info("Info meassage");
		// logger.warn("warning message");
	}

}
