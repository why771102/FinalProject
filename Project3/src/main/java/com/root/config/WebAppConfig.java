package com.root.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configurable
@EnableWebMvc
@ComponentScan("com")   //他會去找哪些地方有Controller要被控管
public class WebAppConfig implements WebMvcConfigurer {				//本類別提供組態資訊，例如要到哪裡找視圖檔，有哪些Controller要被控管
	
	@Bean
	public ViewResolver internalResourceViewResolver() {								//做一個視圖解析器
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();		//new 一個 resolver
		resolver.setPrefix("/WEB-INF/views/");											//設定前綴路徑
		resolver.setSuffix(".jsp");														//設定後綴路徑
		return resolver;																//回傳這個物件
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resouce = new ResourceBundleMessageSource();
		resouce.setBasename("messages");
		return resouce;
	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/views/css/");
//		registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/views/images/");
//	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(81920000);
		return resolver;
	}

}
