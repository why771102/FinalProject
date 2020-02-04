package com.a.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.ServletContextAware;

import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.service.ShowTimeHistoryService;

@Controller
public class MovieController implements ServletContextAware{
	
	MovieService mService;
	ShowTimeHistoryService sthService;
	ServletContext context;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	
	@Autowired
	public void setService(MovieService mService, ShowTimeHistoryService sthService) {
		this.mService = mService;
		this.sthService = sthService;
	}
	
	@GetMapping("/movieIndex")
	public String showAllProducts(Model model) {
		LocalDate startdate = LocalDate.now();
		Map<Integer, List<ShowTimeHistoryBean>> map = new HashMap<Integer, List<ShowTimeHistoryBean>>();
		for(int day = 0; day < 7; day++) {
			List<ShowTimeHistoryBean> list = sthService.getshowMovie(startdate);
			map.put(day+1, list);
			startdate.plusDays(day);
		}
//		List<>
//		model.addAttribute("sthBeanmap", map);
		return "a/movieTheatreIndex";
	}
	
}
