package com._root.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com._root.config.restful.ExcelViewResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//import com._root.config.restful.ExcelViewResolver;


@Configurable
@EnableWebMvc
//@ComponentScan("com")   //他會去找哪些地方有Controller要被控管
@ComponentScan(basePackages = {"com", "m"})
public class WebAppConfig implements WebMvcConfigurer {				//本類別提供組態資訊，例如要到哪裡找視圖檔，有哪些Controller要被控管
	
	@Bean
	public ViewResolver internalResourceViewResolver() {								//做一個視圖解析器
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();		//new 一個 resolver
		resolver.setPrefix("/WEB-INF/views/");										//設定前綴路徑
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

	@Autowired
	ServletContext context;
	
	@Override
	// 本方法會自動產生一個ContentNegotiationManager
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// 如果Spring無法由延伸檔名、請求標頭判斷出使用者要求的沒有型態，
		// 就使用MediaType.APPLICATION_XML為預設型態。
//	 configurer.defaultContentType(MediaType.TEXT_HTML);
//		 configurer.defaultContentType(MediaType.APPLICATION_XML);
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
	
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver cnvResolver = new ContentNegotiatingViewResolver();
		cnvResolver.setContentNegotiationManager(manager);
		// Define all possible view resolvers
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
//		resolvers.add(pdfViewResolver(context));
		resolvers.add(excelViewResolver());

		cnvResolver.setViewResolvers(resolvers);
		return cnvResolver;
	}
	
//	@Bean
//	public ViewResolver pdfViewResolver(ServletContext context) {
//		return new PdfViewResolver(context);
//	}
	
	@Bean
	public ViewResolver excelViewResolver() {
		return new ExcelViewResolver();
	}
	
	@Bean
	public ServletContext getServletContext() {
		
		return context;
	}
	
	@Bean
	public ObjectMapper objectMapper() {
	     return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}
	
}
