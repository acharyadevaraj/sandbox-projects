package com.learning.h2databaseconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.learning.h2databaseconfig.*")
public class H2DatabaseConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DatabaseConfigApplication.class, args);
	}

}
