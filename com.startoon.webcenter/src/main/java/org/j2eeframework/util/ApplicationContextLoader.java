package org.j2eeframework.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextLoader {

	String[] configLocations = {"applicationContext-hibernate.xml", "applicationContext.xml"};
	
	private ApplicationContext ctx;
	
	private static ApplicationContextLoader instance = new ApplicationContextLoader();
	
	private ApplicationContextLoader() {
		super();
		ctx = new ClassPathXmlApplicationContext(configLocations);
	}
	
	public static ApplicationContextLoader getInstance() {
		return instance;
	}
	
	public ApplicationContext getApplicationContext() {
		return ctx;
	}
	

}
