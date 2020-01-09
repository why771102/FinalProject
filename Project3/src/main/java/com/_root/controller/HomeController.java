package com._root.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.c.model.HallBean;
import com.c.service.HallService;
import com.c.service.impl.HallServiceImpl;

//範本
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("index-a")
	public String indexa(Model model, HttpServletRequest req) {
		return "index-a";
	}
	
	@RequestMapping("index-c")
	public String indexc(Model model, HttpServletRequest req) {
		return "index-c";
	}
	
	@RequestMapping("index-l")
	public String indexl(Model model, HttpServletRequest req) {
		return "index-l";
	}
	
	@RequestMapping("index-m")
	public String indexm(Model model, HttpServletRequest req) {
		return "index-m";
	}
	
	@RequestMapping("index-p")
	public String indexp(Model model, HttpServletRequest req) {
		return "index-p";
	}
	
	@RequestMapping("index-t")
	public String indext(Model model, HttpServletRequest req) {
		return "index-t";
	}
	
	@RequestMapping("index-z")
	public String indexz(Model model, HttpServletRequest req) {
		return "index-z";
	}
}
