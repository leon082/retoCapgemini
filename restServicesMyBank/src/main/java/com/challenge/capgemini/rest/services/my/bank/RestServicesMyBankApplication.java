package com.challenge.capgemini.rest.services.my.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RestServicesMyBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServicesMyBankApplication.class, args);
	}

}
