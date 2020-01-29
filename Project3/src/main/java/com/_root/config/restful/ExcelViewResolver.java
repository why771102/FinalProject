//package com._root.config.restful;
//
//import java.util.Locale;
//
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.ViewResolver;
//
//import com._root.config.restful.MultipleMembersExcelView;
//
//public class ExcelViewResolver implements ViewResolver{
//
//	@Override
//	public View resolveViewName(String viewName, Locale locale) throws Exception {
//		
//		View view = null;
//		if (viewName.startsWith("m/hallSale1")) {
//			view = new MultipleMembersExcelView();
//		} 
////		else if (viewName.startsWith("m/hallSale1"))  {
////			view = new SingleMemberExcelView();
////		} 
//		System.out.println("ExcelViewResolver, viewName=" + viewName + ", return value=" + view);
//		return view;
//      }
//	
//}