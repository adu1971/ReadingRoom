package org.adu.readingroom.config;

import org.adu.readingroom.config.RootApplicationContextConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootApplicationContextConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {

		// Parameters:-
		// location - the directory location where files will be stored
		// maxFileSize - the maximum size allowed for uploaded files
		// maxRequestSize - the maximum size allowed for multipart/form-data requests
		// fileSizeThreshold - the size threshold after which files will be written to disk
		MultipartConfigElement multipartConfig = new MultipartConfigElement("/home/adu", 1048576, 10485760, 0);
		registration.setMultipartConfig(multipartConfig);
	}

}
