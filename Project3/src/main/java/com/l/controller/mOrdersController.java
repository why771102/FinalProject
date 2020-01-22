package com.l.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
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
	
	@ResponseBody
	@RequestMapping("/morders/{movieId}")
	public List<ShowTimeHistoryBean> getPlayStartTime(@PathVariable("movieId") Integer movieId) {

		// 用movieId跟status查runningBean
		RunningBean runningBean = service.getRunningsByMovieId(movieId).get(0);
		
		// 用runningId查PlayStartTimeBean
		List<ShowTimeHistoryBean> beans =service.getplayStartTime(runningBean.getRunID());
		
		// 返回一串PlayStartTime
		return beans;
		
		
	}

	
	
	
}
