package com.xiaoma.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//��������·��
@Configuration
public class StaticConfiguration extends WebMvcConfigurerAdapter{
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/image/**").addResourceLocations("file:///E://Skins/");
		
		
	}
	
	

}
