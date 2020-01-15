package com._root.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.p.filter.LoginFilter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppConfig.class};		//提供組態資訊，對應@Configurable，他取代了Spring的組態檔
	}

	@Override
	protected String[] getServletMappings() {			//定義分配器的ServletMapping，"/"表示分配器要處理所有請求
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter charatorEncodingFilter = new CharacterEncodingFilter("UTF-8");
		LoginFilter loginFilter = new LoginFilter();
		return new Filter[] {charatorEncodingFilter,loginFilter};
	}

}
