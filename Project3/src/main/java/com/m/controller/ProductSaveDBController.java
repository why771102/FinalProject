package com.m.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.m.service.ProductSaleEarnService;
import com.m.service.ProductSaleService;

@Controller
public class ProductSaveDBController {

	ServletContext context;
	ProductSaleService service;
	ProductSaleEarnService pService;

//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	public void setService(ProductSaleService service) {
		this.service = service;
	} 

	@Autowired
	public void setService(ProductSaleEarnService pService) {
		this.pService = pService;
	} 
	
	
	@GetMapping(value = "product/save")
	public String toProductSave(Model model) {
		return "m/productSave";
	}
	
	@ModelAttribute
	public void saveFoodToDB() {
		System.out.println("---開始---");
		pService.saveFoodInfoToDB();
		System.out.println("---結束---");
	}
	
	@ModelAttribute
	public void savePeripheralToDB() {
		System.out.println("---開始---");
		pService.savePheriperalDB();
		System.out.println("---結束---");
	}
	
}