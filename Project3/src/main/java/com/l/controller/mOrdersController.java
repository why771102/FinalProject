package com.l.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a.model.MovieBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.service.mOrdersService;


@Controller
public class mOrdersController {
	mOrdersService service;
	@Autowired
	public void setService(mOrdersService service) {
		this.service = service;
	}
	//查詢所有電影之狀態為1
	@RequestMapping("/queryMovie")
	public String getMovieStatus1(Model model) {
		List<MovieBean> list=service.getMovieStatus1();
		model.addAttribute("AllMovies", list);
		return "l/Movie";
	}
	
	@RequestMapping("/morders/{movieid}")
	public String getplayStartTime(@PathVariable("movieid")Integer runID,Model model) {
		List<ShowTimeHistoryBean> list=service.getplayStartTime(runID);
		model.addAttribute("ShowTimeId", list);
		return "morders";
	}

	
	
	
}
