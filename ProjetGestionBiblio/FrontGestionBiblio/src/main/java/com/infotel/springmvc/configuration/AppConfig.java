package com.infotel.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.infotel")
public class AppConfig extends WebMvcConfigurerAdapter{


	/**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    @Override
   public void addCorsMappings(CorsRegistry registry) {
     registry.addMapping("/**").allowedOrigins("*");
    }
    
}

