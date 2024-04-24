package com.user.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProductApplication.class, args);
	}

	@Bean
    public RestTemplate getRestTemplate() {
       return new RestTemplate();
    }
}
