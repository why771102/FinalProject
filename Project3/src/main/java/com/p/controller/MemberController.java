package com.p.controller;

import java.util.HashMap;

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
	@Autowired
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
	public String processMemberRegister(@ModelAttribute("memberBean")MemberBean mb,Model model) {
		HashMap<String, String> errorMsgMap = new HashMap<String, String>(); //用來放錯誤訊息
		if(mb.getName() == null || mb.getName().trim().length() == 0) {
			errorMsgMap.put("nameEmptyError", "姓名欄位不得空白!");
		}
		if(mb.getAccount() == null || mb.getAccount().trim().length() == 0) {
			errorMsgMap.put("accountEmptyError", "帳號欄位不得空白!");
		}
		if(mb.getPassword() == null || mb.getPassword().trim().length() == 0) {
			errorMsgMap.put("passwordEmptyError", "密碼欄位不得空白!");
		}
		if(mb.getuID() == null || mb.getuID().trim().length() == 0) {
			errorMsgMap.put("uIDEmptyError", "身分證字號欄位不得空白!");
		}
		if(mb.getBirth() == null || mb.getBirth().trim().length() == 0) {
			errorMsgMap.put("birthEmptyError", "出生年月日欄位不得空白!");
		}
		if(mb.getMobile() == null || mb.getMobile().trim().length() == 0) {
			errorMsgMap.put("mobileEmptyError", "連絡電話欄位不得空白!");
		}
		if(mb.getEmail() == null || mb.getEmail().trim().length() == 0) {
			errorMsgMap.put("emailEmptyError", "email欄位不得空白!");
		}
		if(mb.getAddress() == null || mb.getAddress().trim().length() == 0) {
			errorMsgMap.put("addressEmptyError", "住址欄位不得空白!");
		}
		//接下來要寫有錯的話要接到哪個頁面
		
		boolean ae = service.accountExists(mb.getAccount());
		if(ae == true) {
			errorMsgMap.put("accountExistError", "帳號已存在!");
		}
		boolean ue = service.UIDExists(mb.getuID());
		if(ue == true) {
			errorMsgMap.put("uIDtExistError", "身分證字號已存在!");
		}
		if(!errorMsgMap.isEmpty()) {
			model.addAttribute("errorMsgMap",errorMsgMap);
			return "register";
		}
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
	
	//以下為判斷登入的方法
	@RequestMapping(value="/member/login")
	public String logincheck() {
		
		
		return null;
	}
	
	
	

}
