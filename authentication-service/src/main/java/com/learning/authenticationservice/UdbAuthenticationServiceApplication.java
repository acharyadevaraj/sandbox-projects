package com.learning.authenticationservice;

import com.learning.authenticationservice.model.Role;
import com.learning.authenticationservice.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.learning.authenticationservice.*")
public class UdbAuthenticationServiceApplication {

	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	public void initUsers() {
		try {

			Role role_admin = Role.builder().name("ADMIN").build();
			Role role_user = Role.builder().name("USER").build();
			roleRepository.save(role_admin);
			roleRepository.save(role_user);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UdbAuthenticationServiceApplication.class, args);
	}

}
