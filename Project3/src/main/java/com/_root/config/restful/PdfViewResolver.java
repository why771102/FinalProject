package com._root.config.restful;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com._root.config.restful.HallSalePdfView;
 
public class PdfViewResolver implements ViewResolver, ServletContextAware{
	
	ServletContext context;

	public PdfViewResolver(ServletContext context2) {
		setServletContext(context2);
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		View view = null;
		if (viewName.startsWith("hall/sale/hallSale")) {
			// 由於要展示如何顯示位於檔案內的資料，所以傳入ServletContext物件以便開啟文字檔。
			view = new HallSalePdfView(context);
		} 
//		System.out.println("PdfViewResolver, viewName=" + viewName + ", return value=" + view);
		return view;
      }
	
}