package com.learning.authenticationservice.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.learning.authenticationservice.config.JwtConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * The {@code JwtTokenManager} class is a service responsible for managing JSON
 * Web Tokens (JWT) for authentication purposes.
 * 
 * @author AcharyaD
 *
 */
@Service
public class JwtTokenManager {

	private final JwtConfig jwtConfig;

	public JwtTokenManager(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	/**
	 * Extracts the username from the given JWT token.
	 * 
	 * @param token The JWT token from which to extract the username.
	 * @return The username extracted from the JWT token.
	 */
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	/**
	 * Extracts the expiration date from the given JWT token.
	 * 
	 * @param token The JWT token from which to extract the expiration date.
	 * @return The expiration date extracted from the JWT token.
	 */
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	/**
	 * Extracts a specific claim from the given JWT token.
	 * 
	 * @param token          The JWT token from which to extract the claim.
	 * @param claimsResolver The function to resolve the specific claim from the JWT claims.
	 * 
	 * @return The value of the specified claim extracted from the JWT token.
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * Extracts all claims from the given JWT token.
	 * 
	 * @param token The JWT token from which to extract all claims.
	 * @return The Claims object containing all the claims extracted from the JWT token.
	 */
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
	}

	/**
	 * Checks if the given JWT token is expired.
	 * 
	 * @param token The JWT token to check for expiration.
	 * @return True if the token is expired, otherwise false.
	 */
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	/**
	 * Validates the given JWT token against the provided UserDetails.
	 * 
	 * @param token       The JWT token to validate.
	 * @param userDetails The UserDetails representing the user details to validate against.
	 * 
	 * @return True if the token is valid for the provided user, otherwise false.
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	/**
     * Generates a new JWT token for the given Authentication object.
     * 
     * @param authentication The Authentication object representing the authenticated user.
     * @return The generated JWT token as a String.
     */
	public String generateToken(Authentication authentication) {
		Map<String, Object> claims = new HashMap<>();
		String username = authentication.getName();
		return createToken(claims, username);
	}

	/**
     * Creates a new JWT token with the provided claims and username.
     * 
     * @param claims 	The claims to include in the JWT token.
     * @param userName 	The username to set as the subject in the JWT token.
     * @return The generated JWT token as a String.
     */
	private String createToken(Map<String, Object> claims, String userName) {
		return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * jwtConfig.getExpiration()))
				.signWith(getSignKey(), SignatureAlgorithm.valueOf(jwtConfig.getSignature())).compact();
	}

	/**
     * Gets the signing key for JWT token verification.
     * 
     * @return The signing key as a Key object.
     */
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(jwtConfig.getSecret());
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
