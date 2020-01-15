package com.c.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c.model.HallBean;
import com.c.model.SeatsBean;
import com.c.service.HallService;
import com.c.service.SeatsService;
import com.google.gson.Gson;

@Controller
public class SeatsController {

	SeatsService sservice;
	HallService hservice;
	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(SeatsService sservice, HallService hservice) {
		this.sservice = sservice;
		this.hservice = hservice;
	}

	@GetMapping(value = "/seats/addSeats")
	public String refreshSeatsChart() {
		return "c/addSeats";
	}
	
	@PostMapping(value="/seats/addSeats")
	public String saveSeats(@RequestParam ("seats") String seats,
			@RequestParam ("hallID") String hallID,
			@RequestParam ("rowNum") String rowNum,
			@RequestParam ("colNum") String colNum,
			@RequestParam ("noOfSeats") String noOfSeats,
			Model model) {
		System.out.println(hallID);
		sservice.saveSeats(seats, hallID);
		hservice.updateHallRC(hallID, Integer.parseInt(colNum), Integer.parseInt(rowNum), Integer.parseInt(noOfSeats));
		return "/index-c";
	}
	
	@GetMapping(value = "/seats/showSeats")
	public String showHallSeats(Model model) {
		String hallID = hservice.getAllHallTags();
		model.addAttribute("hallID", hallID);
		return "c/showSeats";
	}

	@PostMapping(value="/seats/showSeats")
	public @ResponseBody Map<Integer, String> showSeatChart(Model model, @RequestParam ("hallID") String hallID) {
		HallBean hb = hservice.getHall(hallID);
		String hallStatus = hservice.getHallStatus(hallID);
		System.out.println(hallStatus);
		System.out.println("HB: " + hb.getColNum());
		List<SeatsBean> list = sservice.getAllSeatsUsingHallID(hallID);
		//傳回值是['aaaaaa'] 可以直接餵進jsp的mapchart裡
		String[] seats = sservice.showSeatChart(list, hb.getColNum(), hb.getRowNum());
		for(int i = 0; i < seats.length; i++) {
			System.out.println(seats[i]);
		}
		Map<Integer, String> map = new HashMap<Integer, String>();
		Gson g = new Gson();
		String seat = g.toJson(seats);
		map.put(1, seat);
		map.put(2, hallStatus);
//		System.out.println(seat);
//		model.addAttribute("seat", seat);
//		model.addAttribute("hallStatus", hallStatus);
		return map;
	}
	
	@PostMapping(value="/seats/updateSeats")
	public String updateSeatChart(@RequestParam ("seats") String seats,
			@RequestParam("hallID") String hallID) {
		System.out.println("THIS IS CONTROLLER UPDATESEATCHART");
		String s = "seats";
		String[] seatsArray = sservice.stringToStringArray(seats, hallID);
		System.out.println(hallID);
		for(int seat = 0 ; seat < seatsArray.length; seat++) {
			System.out.println(seatsArray[seat]);
			sservice.updateSeatStatus(1, seatsArray[seat], s);
		}
		return "c/showSeats";
	}
	
	
	
}
