package com.medicalservice.user.config;

import org.springframework.context.annotation.Bean;
<<<<<<< HEAD
=======
import org.springframework.context.annotation.Configuration;
>>>>>>> origin/sourav

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
<<<<<<< HEAD

=======
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
>>>>>>> origin/sourav
public class UserConfig {
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
<<<<<<< HEAD
				.apis(RequestHandlerSelectors.basePackage("com.medicalservicesystem.user")).build();
=======
				.apis(RequestHandlerSelectors.basePackage("com.medicalservice.user")).build();
>>>>>>> origin/sourav
	}

}
