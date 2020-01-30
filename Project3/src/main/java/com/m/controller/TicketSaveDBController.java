package com.m.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.m.service.TicketSaleEarnService;

@Controller
public class TicketSaveDBController {

	ServletContext context;
	TicketSaleEarnService service;
	
//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	public void setService(TicketSaleEarnService service) {
		this.service = service;
	} 
	
	@GetMapping(value = "ticket/save")
	public String toProductSave(Model model) {
		return "m/ticketSave";
	}
	
	@ModelAttribute
	public void saveFoodToDB() {
		System.out.println("---開始---");
		service.saveTicketInfoToDB();
		System.out.println("---結束---");
	}
	
}
