package com.medicalservice.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableEurekaClient
public class DoctormoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctormoduleApplication.class, args);
	}

}
