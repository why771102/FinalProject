package com.a.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.ServletContextAware;

import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.service.RunningService;
import com.a.service.ShowTimeHistoryService;
import com.google.gson.Gson;

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

		Gson gson = new Gson();
		String showtimelistJSON = gson.toJson(allshowtimeHistory);
		model.addAttribute("movielist", listofMovies);
		model.addAttribute("allshowtimelistJSON", showtimelistJSON);
		return "a/movieTheatreIndex";
	}
	
	@PostMapping("/purchaseTickets")
	public String getDatesAfterChoosingMovie() {
		
		return "a/movieTheatreIndex";
	}
	
}
