package com.etiya.ecommercedemopair3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceDemoPair3Application {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceDemoPair3Application.class, args);

	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
