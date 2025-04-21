package com.arun.insurance.orginal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;

@SpringBootApplication
public class CrudNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudNewApplication.class, args);
	}
		@Bean
		public SimpleMailMessage simpleMailMessage() {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			return simpleMailMessage;
		}
	
}
