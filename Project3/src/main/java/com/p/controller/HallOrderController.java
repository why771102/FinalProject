package com.p.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.p.model.HallOrderBean;
import com.p.model.MemberBean;
import com.p.service.HallOrderService;
import com.p.service.MemberService;

public class HallOrderController {
	HallOrderService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	@Autowired
	public void setService(HallOrderService service) {
		this.service = service;
	}
	
	//以下為新增包廳申請的方法
	@RequestMapping(value="/hallOrder/apply", method = RequestMethod.GET)
	public String hallOrderApply(Model model) {
		HallOrderBean hob = new HallOrderBean();
		model.addAttribute("hallOrderBean",hob);
		return "hallOrderApply";
	}
	@RequestMapping(value = "/hallOrder/apply", method = RequestMethod.POST)
	public String processMemberRegister(@ModelAttribute("hallOrderBean")HallOrderBean hob) {
		service.hallOrderApply(hob);
		return "hallOrderApply";
	}
	
}
