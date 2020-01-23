package com.l.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.ProductsBean;
import com.l.service.mOrdersService;


@Controller
public class mOrdersController {
	mOrdersService service;
	@Autowired
	public void setService(mOrdersService service) {
		this.service = service;
	}

	
	@RequestMapping("/queryMovie") 
	public String showAllMovie(Model model,HttpServletRequest request,HttpServletResponse response) {
		LocalDate today = (LocalDate.now());
		LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		String dateTime = today.toString() + " " + time.toString();
		List<RunningBean> rb = service.getAllOnMoive(today);
		model.addAttribute("AllMovies", rb);   
 		return "l/Movie";
	}
	
	@RequestMapping("/queryStartTime/{runID}") 
		public String queryStartTime(@PathVariable("runID")Integer runID,Model model,HttpServletRequest request,HttpServletResponse response) {
			List<ShowTimeHistoryBean> sthb=service.getplayStartTime(runID);
			model.addAttribute("playStartTime",sthb);
			return "l/queryStartTime";
		}
	
//	//用電影ID查詢所有RUNID時間在release和expectedOffDate之間
//	@RequestMapping("/queryMovie")
//	public String getRunningID(Model model,HttpServletRequest request,HttpServletResponse response){
//		LocalDate today = (LocalDate.now());
//		LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
//		String dateTime = today.toString() + " " + time.toString();
//		List<RunningBean> list=service.getRunningID();
//		model.addAttribute("AllMovies", list);
//		return "l/Movie";
//	}
	
	
	//	//查詢所有電影之狀態為1
//	@RequestMapping("/queryMovie")
//	public String getMovieStatus1(Model model) {
//		List<MovieBean> list=service.getMovieStatus1();
//		model.addAttribute("AllMovies", list);
//		return "l/Movie";
//	}
//	
//	@ResponseBody
//	@RequestMapping("/morders/{movieID}")
//	public List<ShowTimeHistoryBean> getPlayStartTime(@PathVariable("movieID") Integer movieID) {
//
//		// 用movieId查runningBean但只要一個runID
//		List<Integer> runninglist =new ArrayList<>();
//		List <RunningBean> runningBean= service.getRunningsByMovieId(movieID);
//		for(RunningBean rb:runningBean) {
//			runninglist.add(rb.getRunID());
//		}
//		
//		// 用runningId查ShowTimeHistoryBean
//		List<ShowTimeHistoryBean> sthb =service.getplayStartTime(runninglist.get(0));
//		
//		// 返回一串PlayStartTime
//		return sthb;
//		
//		
//	}

	
	
	
}
