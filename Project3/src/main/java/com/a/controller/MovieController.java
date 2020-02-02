package com.a.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.ServletContextAware;

import com.a.service.MovieService;
import com.l.model.ProductsBean;

@Controller
public class MovieController implements ServletContextAware{
	
	MovieService mService;
	ServletContext context;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	
	@Autowired
	public void setService(MovieService mService) {
		this.mService = mService;
	}
	
	@GetMapping("/movieIndex")
	public String showAllProducts(Model model) {
		return "a/movieTheatreIndex";
	}
	
}
