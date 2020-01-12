package com.c.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.c.model.SeatsBean;
import com.c.service.SeatsService;
import com.google.gson.Gson;

@Controller
public class SeatsController {

	SeatsService service;
	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(SeatsService service) {
		this.service = service;
	}

	@GetMapping(value = "/seats/addSeats")
	public String refreshSeatsChart() {
		return "c/addSeats";
	}
	
	@PostMapping(value="/seats/addSeats")
	public void saveSeats(@RequestParam ("seats") String seats,
			@RequestParam ("hallID") String hallID,
			Model model) {
		Gson gson = new Gson();

		String[] array = gson.fromJson(seats, String[].class);
		for(int seat = 0; seat < array.length; seat++) {
			String row = array[seat].substring(0, 1);
			Integer seatNo =  Integer.parseInt(array[seat].substring(array[seat].length()-1, array[seat].length()));
			String seatID = hallID+row+seatNo;
			Integer typeOfSeat = 0; //currently all normal seats
			Integer seatStatus = 0; //currently all available to be sold
			SeatsBean sb = new SeatsBean(seatID, row, seatNo, typeOfSeat, seatStatus, hallID);
			service.insertSeats(sb);
			System.out.println(sb);
		}
	}
	
}
