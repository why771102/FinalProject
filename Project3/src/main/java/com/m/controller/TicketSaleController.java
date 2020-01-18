package com.m.controller;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.m.model.HallSaleBean;
import com.m.model.TicketSaleBean;
import com.m.service.TicketSaleService;

@Controller
public class TicketSaleController {
	
	ServletContext context;
	TicketSaleService service;
	
//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	public void setService(TicketSaleService service) {
		this.service = service;
	}
	
	//to ts page1
	@GetMapping(value= "/ticket/sale")
	public String toTicketSale(Model model) {
		TicketSaleBean tsb = new TicketSaleBean();
		model.addAttribute("TicketSaleBean1", tsb);
		return "m/ticketSale1";
	}
	
//	//新增下拉式選單
//	@GetMapping(value = "/ticket/sale")
//	public String addSelection(Model model) {
//		return "m/ticketSale1";
//	}
}
