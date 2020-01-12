package com.p.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.p.model.HallOrderBean;
import com.p.model.MemberBean;
import com.p.service.HallOrderService;
import com.p.service.MemberService;
import com.z.model.EmpBean;
import com.z.model.RoleBean;

@Controller
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
	
	//此為動態新增Hall欄位的
	@ModelAttribute("hallList")
	public List<String> getAllhallID() {
		return service.getAllhallID();
	}
	
	//以下為會員查詢包廳申請
	@RequestMapping(value = "/Member/hallOrderQuery")
	public String hallOrderMemberQuery(Model model,@ModelAttribute("hallOrderBean")HallOrderBean hob) {
		List<HallOrderBean> allMHO = service.hallOrderMQuery(hob.getMb().getMemberID());
		model.addAttribute("allMHO", allMHO);
		return "hallOrderMQuery";
	}
}
