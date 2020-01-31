package com._root.config.restful;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com._root.config.restful.ProductSale1ExcelView;

public class ExcelViewResolver implements ViewResolver{

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		
		View view = null;
		if (viewName.startsWith("product/sale/productSale")) {
			view = new ProductSale1ExcelView();
		} 
		else if (viewName.startsWith("productSaleDetail"))  {
			view = new ProductSale2ExcelView();
		} 
		System.out.println("ExcelViewResolver, viewName=" + viewName + ", return value=" + view);
		return view;
      }
	
}