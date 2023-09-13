package com.xworkz.parkingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
@ComponentScan("com.xworkz.parkingapp")
public class ParkingConfig implements WebMvcConfigurer {
	
	public ParkingConfig() {
		System.out.println("created");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			
		configurer.enable();
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home.jsp");
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lc = new LocalContainerEntityManagerFactoryBean();
		lc.setPersistenceUnitName("jpa");
		return lc;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}
