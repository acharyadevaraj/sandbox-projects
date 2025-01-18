package com.learning.udbserverclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a configuration class for database properties.
 * 
 * @author AcharyaD
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@RefreshScope
@ConfigurationProperties(prefix = "spring.datasource")
public class DbConfigProp {
	private String url;
	private String username;
	private String password;

	@Override
	public String toString() {
		return String.format("{url:%s,username:%s,password:%s}", url, username, password);
	}
}
