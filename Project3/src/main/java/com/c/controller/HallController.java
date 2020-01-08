package com.c.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.c.model.HallBean;
import com.c.service.HallService;
import com.z.model.EmpBean;

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
	
	//以下三個為新增員工方法
	@RequestMapping(value = "/hall/add", method = RequestMethod.GET)
	public String addNewHall(Model model) {
		HallBean hb = new HallBean();
		model.addAttribute("hallBean", hb);
		return "addHall";
	}
	
	@RequestMapping(value = "/hall/add", method = RequestMethod.POST)
	public String processAddNewEmp(@ModelAttribute("hallBean") HallBean hb, BindingResult result) {
		
		String[] suppressedFields = result.getSuppressedFields();
		
		if(suppressedFields.length > 0) {
			throw new RuntimeException("傳入不允許的欄位");
		} 
 		service.insertHall(hb);
		return "redirect:/addHall";
	}
	
	
//	@InitBinder
//	public void whiteListing(WebDataBinder binder) {
//		binder.setAllowedFields("empName", "roleId", "email", "password", "status", "startDate" ,"endDate");
//	}
//	
	//----------------------------------
	
	@RequestMapping(value = "/halls")
	public String getAllEmps(Model model) {
		List<HallBean> allHalls = service.getAllHalls(0);
		model.addAttribute("allHalls", allHalls);
		return "halls";
	}
	
	
	
	
	

}
