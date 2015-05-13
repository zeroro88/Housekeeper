package com.zeroro88.hk;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class SystemWebApplicationInitializer implements WebApplicationInitializer {
    

	

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("contextConfigLocation", "com.zeroro88.hk.config");
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		servletContext.addListener(new ContextLoaderListener(rootAppContext));
		
		System.out.println("=====  Succeed to lanuch Spring SystemWebApplicationInitializer =====");
	}

}
