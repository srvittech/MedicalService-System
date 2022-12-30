package com.medicalServiceSystem.transacation.config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class TransacationConfig {
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.medicalServiceSystem.treatment")).build();
	}
}
