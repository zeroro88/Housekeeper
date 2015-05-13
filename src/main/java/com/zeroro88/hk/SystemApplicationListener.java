package com.zeroro88.hk;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class SystemApplicationListener implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
