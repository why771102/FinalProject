package com.p.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.p.model.MemberBean;
import com.p.service.MemberService;

@Controller
public class MemberController {
	
	MemberService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	public void setService(MemberService service) {
		this.service = service;
	}
	
	//以下為會員註冊的相關方法
	@RequestMapping(value="/member/register", method = RequestMethod.GET)
	public String memberRegister(Model model) {
		MemberBean mb = new MemberBean();
		model.addAttribute("memberBean",mb);
		return "register";
	}
	@RequestMapping(value = "/member/register", method = RequestMethod.POST)
	public String processMemberRegister(@ModelAttribute("memberBean")MemberBean mb) {
		//還要加入判斷
		service.register(mb);
		return "register";
	}
	
	//還要加入白名單限制(Spring MVC P.293 Lab9)
	
	//以下為查詢會員資料的方法
	@RequestMapping(value="/member/query")
	public String memberQuery(@RequestParam("account") String account,Model model) {
		MemberBean mb = service.queryMember(account);
		model.addAttribute("mData", mb);
		return "memberData";
	} 
	
	
	

}
