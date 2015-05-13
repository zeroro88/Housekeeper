package com.zeroro88.hk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.zeroro88.hk.SystemApplicationListener;

@Configuration
@ComponentScan(basePackages = "com.zeroro88.hk")
@Import({PersistenceConfig.class})
public class SpringAppConfig {
    
    @Bean
    public StandardPasswordEncoder getStandardPasswordEncoder() {
    	StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder("ThisIsASecretSoChangeMe");
        return standardPasswordEncoder;
    }
   
    
    @Bean
    public SystemApplicationListener applicationListener() {
    	return new SystemApplicationListener();
    }
}
