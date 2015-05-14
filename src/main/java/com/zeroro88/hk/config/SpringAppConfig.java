package com.zeroro88.hk.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.zeroro88.hk.SystemApplicationListener;
import com.zeroro88.hk.dao.DataBaseInitializer;
import com.zeroro88.hk.mapper.NewsEntryMapper;
import com.zeroro88.hk.mapper.UserMapper;

@Configuration
@ComponentScan(basePackages = "com.zeroro88.hk")
@Import({ PersistenceConfig.class })
public class SpringAppConfig {
	@Resource
	private NewsEntryMapper newsEntryMapper;
	@Resource
	private UserMapper userMapper;

	@Bean
	public StandardPasswordEncoder standardPasswordEncoder() {
		StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder("ThisIsASecretSoChangeMe");
		return standardPasswordEncoder;
	}

	@Bean(initMethod = "initDataBase")
	public DataBaseInitializer dataBaseInitializer() {
		DataBaseInitializer dataBaseInitializer = new DataBaseInitializer(userMapper, newsEntryMapper, standardPasswordEncoder());
		return dataBaseInitializer;
	}

	@Bean
	public SystemApplicationListener applicationListener() {
		return new SystemApplicationListener();
	}
}
