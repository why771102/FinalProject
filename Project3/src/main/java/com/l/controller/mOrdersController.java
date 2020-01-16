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
import com.a.model.RunningBean;
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
	public String getRunbyID(Model model) {
		List<RunningBean> list=service.getRunbyID();
		model.addAttribute("Movies", list);
		return "l/morders";
	}
	

	
}
