package com.l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.a.model.MovieBean;
import com.l.model.MOrderBean;
import com.l.model.ProductsBean;
import com.l.service.ProductsService;
import com.l.service.mOrdersService;


@Controller
public class mOrdersController {
	mOrdersService service;
	@Autowired
	public void setService(mOrdersService service) {
		this.service = service;
	}
		
	@RequestMapping("/morders")
	public String getMovieName(Model model) {
		List<MovieBean> list=service.getMovieName();
		model.addAttribute("Movies", list);
		return "l/morders";
	}
	@RequestMapping("/morders/{runid}")
	public String getRunbyID(@PathVariable("runid")Integer runid,Model model) {
		model.addAttribute("Movies", runid);
		return "redirect:/morders/{runid}/{playStartTime}";
	}
	
	@RequestMapping("/morders/{runid}/{playStartTime}")
	public String getShowTimebyID(@PathVariable("playStartTime")String playStartTime,Model model) {
		model.addAttribute("Movies", playStartTime);
		return "l/morders";
	}

	
}
