package com.a.controller;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.service.RunningService;
import com.a.service.ShowTimeHistoryService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.m.model.ProductSaleEarnBean;

@Controller
public class MovieController implements ServletContextAware{
	
	MovieService mService;
	ShowTimeHistoryService sthService;
	RunningService rservice;
	ServletContext context;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	
	@Autowired
	public void setService(MovieService mService, ShowTimeHistoryService sthService, RunningService rservice) {
		this.mService = mService;
		this.sthService = sthService;
		this.rservice = rservice;
	}
	
	@GetMapping("/movieIndex")
	public String showAllProducts(Model model) {
		LocalDateTime startdate = LocalDateTime.now();
		List<ShowTimeHistoryBean> listofMovies = sthService.getDistinctMovieID(startdate);
		List<ShowTimeHistoryBean> allshowtimeHistory = sthService.getAWeekShowTimeHistoryBean(startdate);
		ShowTimeHistoryBean sthb = new ShowTimeHistoryBean();
		Gson gson = new Gson();
		String showtimelistJSON = gson.toJson(allshowtimeHistory);
		model.addAttribute("movielist", listofMovies);
		model.addAttribute("allshowtimelistJSON", showtimelistJSON);
		model.addAttribute("showtime", sthb);
		return "a/movieTheatreIndex";
	}
	
	@PostMapping("/purchaseTickets")
	public String getDatesAfterChoosingMovie(@RequestParam("showTimeBean") String showtimeBean, Model model) {
		System.out.println("showtimeBean: " + showtimeBean);
//		Staff staff = gson.fromJson(json, Staff.class);
//		Type listType = new TypeToken<ShowTimeHistoryBean>(){}.getType();
//		ShowTimeHistoryBean sthb = new Gson().fromJson(showtimeBean, listType);
//		ShowTimeHistoryBean sthb = new ShowTimeHistoryBean();
//		model.addAttribute("showtime", sthb);
//		System.out.println("@PostMapping(\"/purchaseTickets\"): " + sthb.getRun().getMovie().getTitle());
		return "l/tickets";
	}
	
//	@GetMapping("/purchaseTickets")
//	public String getbuyticket(@ModelAttribute("showtime") ShowTimeHistoryBean sthb, Model model) {
//		model.addAttribute("showtime", sthb);
//		System.out.println("@GetMapping(\"/purchaseTickets\")"+ sthb);
//		return "l/tickets";
//	}
}
