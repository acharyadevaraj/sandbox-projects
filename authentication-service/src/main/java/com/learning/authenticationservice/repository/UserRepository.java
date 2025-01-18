package com.learning.authenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.authenticationservice.model.User;

/**
 * The {@code UserRepository} interface is a Spring Data JPA repository that
 * extends JpaRepository for the User entity.
 * 
 * @author AcharyaD
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	/**
	 * Find a user by their username.
	 * 
	 * @param name The username of the user to find.
	 * @return An Optional containing the User object if found, or an empty.
	 */
	Optional<User> findByUsername(String name);

	/**
	 * Check if a user exists by their username.
	 * 
	 * @param username The username to check.
	 * @return True if a user with the specified username exists, otherwise false.
	 */
	Boolean existsByUsername(String username);

	/**
	 * Check if a user exists by their email address.
	 * 
	 * @param email The email address to check.
	 * @return True if a user with the specified email address exists, otherwise false.
	 */
	Boolean existsByEmail(String email);

	/**
	 * Find a user by their username or email address.
	 * 
	 * @param username The username to search.
	 * @param email    The email address to search.
	 * @return An Optional containing the User object if found, or an empty.
	 */
	Optional<User> findByUsernameOrEmail(String username, String email);
}
