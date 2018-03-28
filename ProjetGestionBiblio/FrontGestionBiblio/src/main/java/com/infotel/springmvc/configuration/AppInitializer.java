package com.infotel.springmvc.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.infotel.config.ConteneurSpringFullJava;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer 
{
	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return new Class[] { ConteneurSpringFullJava.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] { "/" };
	}
	
}
