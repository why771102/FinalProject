package com.l.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.google.gson.Gson;
import com.l.service.mOrdersService;


@Controller
public class mOrdersController {
	mOrdersService service;
	@Autowired
	public void setService(mOrdersService service) {
		this.service = service;
	}
		
	@RequestMapping(value="/morders", method = RequestMethod.GET)
	public String getRunbyID(Model model) {
		List<RunningBean> list=service.getRunbyID();
		model.addAttribute("Movies", list);
		return "l/morders";
	}
	
	@RequestMapping("/morders2")
	public String getRunbyID2(Model model) {
		List<RunningBean> list=service.getRunbyID();
		model.addAttribute("Movies", list);
		return "l/morders2";
	}
	
	
	
	
//	@ModelAttribute("mtitle")
//	public @ResponseBody String getmtitle(){
//		
//		List<MovieBean> list = service.getMovieName();
//		Gson gson = new Gson();
//		List<Map<String,String>> listmap = new ArrayList<>();
//		for(MovieBean mb:list) {
//			Map<String,String> mtitleMap=new HashMap<>();
//			mtitleMap.put("movieID",mb.getMovieID().toString());
//			mtitleMap.put("title",mb.getTitle());
//			listmap.add(mtitleMap);
//		}
//		String mapJson = gson.toJson(listmap);
//		
//		
//		System.out.println(mapJson);
//		return mapJson;	
//	}
	
	
	
}
