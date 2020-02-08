package com.a.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.service.RunningService;
import com.a.service.ShowTimeHistoryService;
import com.google.gson.Gson;
import com.l.service.mOrdersService;
import com.z.model.AnnoBean;
import com.z.service.AnnoService;

@Controller
public class MovieController implements ServletContextAware{
	
	MovieService mService;
	ShowTimeHistoryService sthService;
	RunningService rservice;
	ServletContext context;
	mOrdersService service;
	AnnoService annoService;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	
	@Autowired
	public void setService(MovieService mService, ShowTimeHistoryService sthService, RunningService rservice,mOrdersService service, AnnoService annoService) {
		this.mService = mService;
		this.sthService = sthService;
		this.rservice = rservice;
		this.service=service;
		this.annoService = annoService;
	}
	
	@ModelAttribute("annoList")
	public List<AnnoBean> getannoList() {
		List<AnnoBean> allAnnos = annoService.showAnnoToMember();
		return allAnnos;
	}
	
	@GetMapping("/movieIndex")
	public String showAllProducts(Model model) {
		LocalDateTime startdate = LocalDateTime.now();
		List<RunningBean> listofrunningID = sthService.getDistinctRunID(startdate);
		
		List<Integer> movies = new ArrayList<>();
		for(RunningBean rID: listofrunningID) {
			System.out.println(rID.getMovie().getTitle());
			RunningBean rb = sthService.getDistinctMovies(rID.getRunID());
			if(!movies.contains(rb.getMovie().getMovieID())) {
				movies.add(rb.getMovie().getMovieID());
			}
		}
		List<MovieBean> listmb = new ArrayList<>();
		for(Integer movie:movies) {
			System.out.println(movie);
			MovieBean mb = mService.getMovieBeanById(movie);
			listmb.add(mb);
		}
		List<ShowTimeHistoryBean> allshowtimeHistory = sthService.getAWeekShowTimeHistoryBean(startdate);
		ShowTimeHistoryBean sthb = new ShowTimeHistoryBean();
		Gson gson = new Gson();
		String showtimelistJSON = gson.toJson(allshowtimeHistory);
		model.addAttribute("movielist", listmb);
		model.addAttribute("allshowtimelistJSON", showtimelistJSON);
		model.addAttribute("showtime", sthb);
		return "a/movieTheatreIndex";
	}
	
	@PostMapping("/purchaseTickets")
	public String getDatesAfterChoosingMovie(@RequestParam("showTimeBean") Integer showtimeBean, Model model,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("showtimeBean: " + showtimeBean);
		HttpSession session = request.getSession();
		ShowTimeHistoryBean sthb=  (ShowTimeHistoryBean) service.getStartTimeByID(showtimeBean);
		session.setAttribute("ShowTimeHistory", sthb);
		Cookie cookie = new Cookie("showtimeId",sthb.getShowTimeId().toString());
	    cookie.setMaxAge(7 * 24 * 60 * 60);
	    cookie.setPath("/");
	    response.addCookie(cookie);

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
