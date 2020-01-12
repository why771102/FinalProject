package com.c.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.c.model.HallBean;
import com.c.service.HallService;
import com.google.gson.Gson;

@Controller
public class HallController {
	
	HallService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(HallService service) {
		this.service = service;
	}
	
	//新增廳方法
	@GetMapping(value = "/hall/add")
	public String addNewHall(Model model) {
		HallBean hb = new HallBean();
		model.addAttribute("hallBean", hb);
		return "c/addHall";
	}
	
	@PostMapping(value = "/hall/add")
	public RedirectView processAddNewEmp(Model model, @ModelAttribute("hallBean") HallBean hb, BindingResult result, HttpServletRequest request) {
		String url = request.getContextPath();
		System.out.println(url);
		String[] suppressedFields = result.getSuppressedFields();
		
		if(suppressedFields.length > 0) {
			throw new RuntimeException("傳入不允許的欄位");
		} 
 		service.insertHall(hb);
 		
 		model.addAttribute("hallID", hb.getHallID());
 		
 		RedirectView redirectView = new RedirectView();
 		redirectView.setUrl(url+"/seats/addSeats");
		return redirectView;
	}
	
	
	
	
//	@InitBinder
//	public void whiteListing(WebDataBinder binder) {
//		binder.setAllowedFields("empName", "roleId", "email", "password", "status", "startDate" ,"endDate");
//	}
//	
	//----------------------------------
	
	@RequestMapping(value = "/halls")
	public String getAllHalls(Model model) {
		List<HallBean> allHalls = service.getAllHalls(0);
		model.addAttribute("allHalls", allHalls);
		return "halls";
	}
	
	
	
	
	

}
