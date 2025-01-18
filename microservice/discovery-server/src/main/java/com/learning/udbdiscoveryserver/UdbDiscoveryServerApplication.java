package com.learning.udbdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UdbDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdbDiscoveryServerApplication.class, args);
	}

}
