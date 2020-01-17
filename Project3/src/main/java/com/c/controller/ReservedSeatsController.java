package com.c.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.c.service.ReservedSeatsService;

@Controller
public class ReservedSeatsController {
	
	ReservedSeatsService rservice;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ReservedSeatsService rservice) {
		this.rservice = rservice;
	}
	
	@GetMapping("/reservedSeats/showSeats")
	public String showReservedSeats() {
		rservice.insertSeats();
		return "c/showReservedSeats";
	}
}
