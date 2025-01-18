package com.security.rolebasedauth.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The {@code UserPrincipal} class is a custom class that extends the User class
 * and implements the UserDetails interface to represent the authenticated user
 * (principal) in the application.
 * 
 * @author AcharyaD
 *
 */

public class UserPrincipal extends User implements UserDetails {

	public UserPrincipal(final User user) {
		super(user);
	}

	/**
	 * This method is an overridden method from the UserDetails interface.
	 * It returns a collection of GrantedAuthority objects, representing
	 * the roles that the authenticated user possesses.
	 * 
	 * @return A collection of GrantedAuthority objects representing the user's roles.
	 */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
				.collect(Collectors.toSet());
	}

	/**
	 * Returns whether the user account is non-expired based on the user's active status.
	 *
	 * @return True if the user account is active, otherwise false.
	 */
	@Override
	public boolean isAccountNonExpired() {
		return isActive();
	}

	/**
	 * Returns whether the user account is non-locked based on the user's active status.
	 *
	 * @return True if the user account is non-locked (active), otherwise false.
	 */
	@Override
	public boolean isAccountNonLocked() {
		return isActive();
	}

	/**
	 * Returns whether the user's credentials are non-expired based on the user's active status.
	 *
	 * @return True if the user's credentials are non-expired (active), otherwise false.
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return isActive();
	}

	/**
	 * Returns whether the user account is enabled based on the user's active status.
	 *
	 * @return True if the user account is enabled (active), otherwise false.
	 */
	@Override
	public boolean isEnabled() {
		return isActive();
	}

	@Override
	public String getPassword() {
		return null;
	}

}
