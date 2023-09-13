package com.xworkz.parkingapp.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.xworkz.parkingapp.constant.ApplicationConstant;

public class ParkingWebInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("created"+ this.getClass().getSimpleName());
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("inside getServletConfigClasses");
		return new Class[] {ParkingConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("inside getServletMappings");
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {

		int maxSize=ApplicationConstant.MAX_FILE_SIZE;
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(ApplicationConstant.TEMP_FILE_LOCATION, maxSize, maxSize*2, maxSize/2);
		registration.setMultipartConfig(multipartConfigElement);
	}
}
