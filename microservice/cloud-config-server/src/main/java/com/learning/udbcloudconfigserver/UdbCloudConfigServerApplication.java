package com.learning.udbcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * The main class for the UdbCloudConfigServerApplication. This class represents
 * a Spring Boot application that serves as a configuration server using Spring
 * Cloud Config.
 * 
 * @author AcharyaD
 */

@SpringBootApplication
@EnableConfigServer
public class UdbCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdbCloudConfigServerApplication.class, args);
	}

}
