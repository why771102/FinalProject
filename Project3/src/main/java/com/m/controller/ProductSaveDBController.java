package com.m.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.model.ProductSaleBean;
import com.m.model.ProductSaleEarnBean;
import com.m.service.ProductSaleService;

@Controller

public class ProductSaveDBController {

	ServletContext context;
	ProductSaleService service;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ProductSaleService service) {
		this.service = service;
	} 

	
	@GetMapping(value = "product/save")
	public String toProductSale(Model model) {
		return "m/productSave";
	}
	
	@ModelAttribute
	public void saveDB() {
		System.out.println("---開始---");
//		List<LocalDate> lds = service.getFoodDates();
//		System.out.println("lds.size >>>> " + lds.size());
//		for(LocalDate ld : lds) {
//			System.out.println("Q____Q: " + ld);
//			List<MOrderBean> mod = service.getFoodSCOrder(ld);
//		}
//		System.out.println("lds >>>> " + lds.get(0) + lds.get(1));
//		for(int i=0; i<lds.size(); i++) {
//			System.out.println("check date===> " + lds.get(i));
//			List<MOrderBean> mod = service.getFoodSCOrder(lds);
//			System.out.println("date >>>> " + date);			
//			System.out.println("mod >>>>" + mod.size());
//		}
//		Boolean b = service.savePSEB(service.savePSEB1());
		System.out.println(service.savePSEB(service.savePSEB1()));
		System.out.println("---is saving to DB---");
	}
	
}