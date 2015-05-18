package com.zeroro88.hk.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages="com.zeroro88.hk.mapper")
public class PersistenceConfig {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PersistenceConfig.class);
	@Value("classpath*:mapper/**/*.xml")
	Resource[] mapperLocation;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		try {
			dataSource.setUrl("jdbc:hsqldb:mem:example");
			dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
			dataSource.setUsername("sa");
			dataSource.setPassword("");

		} catch (Exception e) {
			LOGGER.error("Failed to initialize ComboPooledDataSource.", e);
		}

		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize DataSourceTransactionManager to Spring bean container.");
		}
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		transactionManager.setRollbackOnCommitFailure(true);
		return transactionManager;
	}

//	@Bean
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		if (LOGGER.isDebugEnabled()) {
//			LOGGER.debug("Initialize MapperScannerConfigurer to Spring bean container.");
//		}
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
////		mapperScannerConfigurer.setBasePackage("com.zeroro88.hk.mapper");
//		return mapperScannerConfigurer;
//	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource,
			ApplicationContext applicationContext) throws IOException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Initialize SqlSessionFactory to Spring bean container.");
		}
		SqlSessionFactory sqlSessionFactory = null;
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(applicationContext.getResources("classpath:mappers/*.xml"));

		// sessionFactory.setTypeAliasesPackage("com.zeroro88.hk.entity.mybatis");

		try {
			sqlSessionFactory = sessionFactory.getObject();
		} catch (Exception e) {
			LOGGER.error("Failed to create SqlSessionFactory.", e);
		}

		return sqlSessionFactory;
	}
}
