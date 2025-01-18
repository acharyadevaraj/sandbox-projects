package com.learning.postgresconfig.config;

import java.beans.PropertyVetoException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class PrimaryDbConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean db2EntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(db2Datasource());
		em.setPackagesToScan("com.springpostgresconfig.*");
		em.setPersistenceUnitName(env.getProperty("spring.datasource.persistence.unitname"));
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.show-sql", env.getProperty("spring.datasource.hibernate.show.sql"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean
	public DataSource db2Datasource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		} catch (PropertyVetoException e) {
			//LogWriter.error(ModuleName.LOGGER, this, e);
		}
		dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUser(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		dataSource.setAcquireIncrement(1);
		dataSource.setAcquireRetryAttempts(1);
		dataSource.setMaxIdleTime(50);
		dataSource.setMaxPoolSize(8);
		dataSource.setMinPoolSize(1);
		dataSource.setMaxStatements(50);
		dataSource.setMaxStatementsPerConnection(50);
		dataSource.setMaxConnectionAge(100);
		dataSource.setMaxIdleTimeExcessConnections(100);
		dataSource.setIdleConnectionTestPeriod(50);
		dataSource.setTestConnectionOnCheckin(true);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager db2TransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(db2EntityManager().getObject());
		return transactionManager;
	}

}