package com.cars.cardemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class CardemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardemoApplication.class, args);
	}

}
