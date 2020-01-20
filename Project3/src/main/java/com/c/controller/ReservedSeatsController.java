package com.c.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c.model.HallBean;
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
//		rservice.insertSeats();
		
		//insert seat number into number of seats table;
	
//		List<ReservedSeatsBean> list = rservice.getAllSeats(2);
//		System.out.println(list.get(0).getDate());
//		NumberOfSeatsBean nosb = new NumberOfSeatsBean(list.get(0).getDate(), list.size(), list.get(0).getSeatsBean().getHallBean().getHallID());
//		nosservice.insertNumberofSeats(nosb);
		return "c/showReservedSeats";
	}
	
	
//	應該傳到前端 電影名稱、廳、訂票數、日期
	@PostMapping("/reservedSeats/showSeats")
	public @ResponseBody Map<Integer, String>showReservedSeats() {
		//由前端傳入
		Integer showTimeID = 2;
		List<ReservedSeatsBean> listsb = rservice.getAllSeats(showTimeID);
		String date = listsb.get(0).getShowtimeHistoryBean().getPalyStartTime();
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
		map.put(1, seat);//座位表
		map.put(2, "2"); //訂票數number of tickets user wishes to buy
		map.put(3, hb.getHallID());//廳
		map.put(4, "Inception");//電影名稱
		map.put(5, date);//日期
//		map.put(2, showTimeID.toString());
		return map;
	}
	
	//需要傳入廳
	@PostMapping("/reservedSeats/reserveSeats")
	public String reservedSeats(@RequestParam("seats") String seats) {
		String[] seatsArray = sservice.stringToStringArray(seats, "A");
		for(int seat = 0; seat < seatsArray.length; seat++) {
			ReservedSeatsBean rsb = rservice.getSeat(2, seatsArray[seat]);
			System.out.println("reservedSeats rsb.getShowtimeHistoryBean().getShowTimeId(): " + rsb.getShowtimeHistoryBean().getShowTimeId());
			rservice.reserveSeat(rsb);
		}
		return "/index-c";
	}
}
