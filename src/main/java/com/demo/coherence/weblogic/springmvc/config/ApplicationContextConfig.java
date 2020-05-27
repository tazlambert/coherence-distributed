package com.demo.coherence.weblogic.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration

@ComponentScan("com.demo.coherence.weblogic.springmvc.*")

public class ApplicationContextConfig {  
 
	 

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver 
		      viewResolver = new InternalResourceViewResolver();
		System.out.println("Create Bean viewResolver");
		
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	} 
  

}