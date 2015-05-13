package com.zeroro88.hk.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceConfig.class);

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		try {
			dataSource.setUrl("jdbc:hsqldb:mem:example");
			dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
			dataSource.setUsername("sa");
			dataSource.setPassword("");

		}
		catch (Exception e) {
			LOGGER.error("Failed to initialize ComboPooledDataSource.", e);
		}

		return dataSource;
	}
}
