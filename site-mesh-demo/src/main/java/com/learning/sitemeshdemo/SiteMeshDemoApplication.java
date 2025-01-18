package com.learning.sitemeshdemo;

import com.learning.sitemeshdemo.config.CustomSiteMeshFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.learning.sitemeshdemo.*")
@SpringBootApplication
public class SiteMeshDemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SiteMeshDemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SiteMeshDemoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new CustomSiteMeshFilter()); // adding sitemesh filter
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
