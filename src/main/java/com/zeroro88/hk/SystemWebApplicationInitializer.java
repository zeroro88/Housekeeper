package com.zeroro88.hk;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class SystemWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("contextConfigLocation", "com.zeroro88.hk.config");
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		servletContext.addListener(new ContextLoaderListener(rootAppContext));
		ServletRegistration.Dynamic restService = servletContext.addServlet("RestService", SpringServlet.class);
		restService.setInitParameter("com.sun.jersey.config.property.packages", "com.zeroro88.hk.rest");
		restService.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
		restService.addMapping("/rest/*");
		FilterRegistration.Dynamic springSecurityFilterChain = servletContext.addFilter("springSecurityFilterChain",
				"org.springframework.web.filter.DelegatingFilterProxy");
		EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC);
		springSecurityFilterChain.addMappingForUrlPatterns(dispatcherTypes, true, "/");
		System.out.println("=====  Succeed to lanuch Spring SystemWebApplicationInitializer =====");
	}

}
