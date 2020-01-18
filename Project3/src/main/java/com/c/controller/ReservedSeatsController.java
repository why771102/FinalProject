package com.c.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.c.model.SeatsBean;
import com.c.service.ReservedSeatsService;
import com.c.service.SeatsService;

@Controller
public class ReservedSeatsController {
	
	ReservedSeatsService rservice;
	SeatsService sservice;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ReservedSeatsService rservice, SeatsService sservice) {
		this.rservice = rservice;
		this.sservice = sservice;
	}
	
	@GetMapping("/reservedSeats/showSeats")
	public String showReservedSeats(Integer showTimeID, Date date) {
		rservice.insertSeats();
		Date date1 = new Date(2020-01-19);
		List<SeatsBean> listsb = rservice.getAllSeats(1, date1);
		
		return "c/showReservedSeats";
	}
}
