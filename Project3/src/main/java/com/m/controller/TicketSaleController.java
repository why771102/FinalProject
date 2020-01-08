package com.m.controller;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/ticketSale")
public class TicketSaleController {
	
	ServletContext context;

//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	
	
	
}
