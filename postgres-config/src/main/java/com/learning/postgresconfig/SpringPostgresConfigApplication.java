package com.learning.postgresconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springpostgresconfig.*")
public class SpringPostgresConfigApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringPostgresConfigApplication.class, args);
	}

}
