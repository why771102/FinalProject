package com.c.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c.model.HallBean;
import com.c.model.NumberOfSeatsBean;
import com.c.model.ReservedSeatsBean;
import com.c.service.HallService;
import com.c.service.NumberOfSeatsService;
import com.c.service.ReservedSeatsService;
import com.c.service.SeatsService;
import com.google.gson.Gson;

@Controller
public class ReservedSeatsController {
	
	ReservedSeatsService rservice;
	SeatsService sservice;
	HallService hservice;
	NumberOfSeatsService nosservice;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ReservedSeatsService rservice, SeatsService sservice, HallService hservice, NumberOfSeatsService nosservice) {
		this.rservice = rservice;
		this.sservice = sservice;
		this.hservice = hservice;
		this.nosservice = nosservice;
	}
	
	@GetMapping("/reservedSeats/showSeats")
	public String insertReservedSeats() {
		//insert seats into reserved seats table;
//		List<ShowTimeHistoryBean> list = rservice.insertSeats();
		
		//insert seat number into number of seats table;
	
		List<ReservedSeatsBean> list = rservice.getAllSeats(1);
		System.out.println(list.get(0).getDate());
		NumberOfSeatsBean nosb = new NumberOfSeatsBean(list.get(0).getDate(), list.size(), list.get(0).getSeatsBean().getHallBean().getHallID());
		nosservice.insertNumberofSeats(nosb);
		return "c/showReservedSeats";
	}
	
	@PostMapping("/reservedSeats/showSeats")
	public @ResponseBody Map<Integer, String>showReservedSeats() {
		List<ReservedSeatsBean> listsb = rservice.getAllSeats(1);
		System.out.println(listsb.get(0).getSeatID());
		String hallID = listsb.get(0).getSeatsBean().getSeatID().toString().substring(0,1);
		HallBean hb = hservice.getHall(hallID);
		String[] seats = rservice.showSeatChart(listsb, hb.getColNum(), hb.getRowNum(), hallID);
		for(int i = 0; i < seats.length; i++) {
			System.out.println(seats[i]);
		}
		Map<Integer, String> map = new HashMap<Integer, String>();
		Gson g = new Gson();
		String seat = g.toJson(seats);
		map.put(1, seat);
//		map.put(2, showTimeID.toString());
		return map;
	}
//	@PostMapping("/reservedSeats/showSeats")
//	public String showReservedSeats(Integer showTimeID, String date) {
//		String date1 = "2020-01-19";
//		List<ReservedSeatsBean> listsb = rservice.getAllSeats(1, date1);
//		System.out.println(listsb.get(0).getSeatsBean().getSeatID());
//		return null;
//	}
}
