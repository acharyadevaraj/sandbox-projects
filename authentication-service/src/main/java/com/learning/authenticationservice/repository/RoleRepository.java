package com.learning.authenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.authenticationservice.model.Role;

/**
 * The {@code RoleRepository} interface is a Spring Data JPA repository that
 * extends JpaRepository for the Role entity.
 * 
 * @author AcharyaD
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	
	/**
	 * Finds a role by its name.
	 * 
	 * @param name The name of the role to find.
	 * @return An Optional containing the Role object if found, or an empty.
	 */
	Optional<Role> findByName(String name);
}
