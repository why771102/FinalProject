package com.p.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.p.model.HallOrderBean;
import com.p.model.MemberBean;
import com.p.service.MemberService;
import com.p.validator.MemberValidator;

@Controller
public class MemberController {
	
	MemberService service;
	ServletContext context;
	
//	@Autowired
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
	public String processMemberRegister(@ModelAttribute("memberBean")MemberBean mb,Model model,BindingResult result,HttpServletRequest request) {
		HashMap<String, String> errorMsgMap = new HashMap<String, String>();
		MemberValidator validator = new MemberValidator();
		// 呼叫Validate進行資料檢查
		validator.validate(mb, result);
		if (result.hasErrors()) {
			return "register";
		}
		
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
		
		
		 //用來放錯誤訊息
//		if(mb.getName() == null || mb.getName().trim().length() == 0) {
//			errorMsgMap.put("nameEmptyError", "姓名欄位不得空白!");
//		}
//		if(mb.getAccount() == null || mb.getAccount().trim().length() == 0) {
//			errorMsgMap.put("accountEmptyError", "帳號欄位不得空白!");
//		}
//		if(mb.getPassword() == null || mb.getPassword().trim().length() == 0) {
//			errorMsgMap.put("passwordEmptyError", "密碼欄位不得空白!");
//		}
//		if(mb.getuID() == null || mb.getuID().trim().length() == 0) {
//			errorMsgMap.put("uIDEmptyError", "身分證字號欄位不得空白!");
//		}
//		if(mb.getBirth() == null || mb.getBirth().trim().length() == 0) {
//			errorMsgMap.put("birthEmptyError", "出生年月日欄位不得空白!");
//		}
//		if(mb.getMobile() == null || mb.getMobile().trim().length() == 0) {
//			errorMsgMap.put("mobileEmptyError", "連絡電話欄位不得空白!");
//		}
//		if(mb.getEmail() == null || mb.getEmail().trim().length() == 0) {
//			errorMsgMap.put("emailEmptyError", "email欄位不得空白!");
//		}
//		if(mb.getAddress() == null || mb.getAddress().trim().length() == 0) {
//			errorMsgMap.put("addressEmptyError", "住址欄位不得空白!");
//		}
		//接下來要寫有錯的話要接到哪個頁面
		
		
	}
	
	
	//以下為查詢會員資料的方法
	@GetMapping("/member/query")
	public String memberQuery(HttpServletRequest request,Model model) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int nMID = Integer.parseInt(mID);
		MemberBean mb = service.queryMember(nMID);
		model.addAttribute("mData", mb);
		return "memberData";
	}
	
	@PostMapping("/member/query")
	public String updateMember(@ModelAttribute("mData")MemberBean mb) {
		service.updateMember(mb);
		return "redirect:/member/query";
	}
	
	//以下為導入登入頁面的controller
	@RequestMapping(value="/member/login", method = RequestMethod.GET)
	public String login(Model model){
		MemberBean mb = new MemberBean();
		model.addAttribute("memberBean",mb);
		return "login";
	}
	
	//以下為判斷登入的方法
	@RequestMapping(value="/member/login", method = RequestMethod.POST)
	public String logincheck(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("memberBean")MemberBean mb,Model model) {
		HttpSession session = request.getSession();
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		if(mb.getAccount() == null || mb.getAccount().trim().length() == 0) {
			errorMsgMap.put("IDError","帳號欄位不得空白，請重新輸入!");
		}
		if(mb.getPassword() == null || mb.getPassword().trim().length() == 0) {
			errorMsgMap.put("pwdError","密碼欄位不得空白，請重新輸入!");
		}
		
		MemberBean mb2 = service.checkIdPassword(mb.getAccount(), mb.getPassword());
		if(mb2 != null) {
			//登入成功，將mb2物件放進session範圍中，識別字串為LoginOK
			session.setAttribute("LoginOK", mb2);
			Cookie cookie = new Cookie("account",mb2.getAccount());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("name",mb2.getName());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("memberID",mb2.getMemberID().toString());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		    Cookie[] cookies = request.getCookies();
			String mID = null;
			for (Cookie cookiess : cookies) {
				String name = cookie.getName();
				if(name.equals("memberID")) {
					mID = cookie.getValue();
				}
			}
			int nMID = Integer.parseInt(mID);
			service.updateLastLoginTime(mb.getLastLogInTime(), nMID);
		    
		}else {
			errorMsgMap.put("IDPwdError","帳號或密碼錯誤，請重新輸入!");
		}
		if(!errorMsgMap.isEmpty()) {
			model.addAttribute("errorMsgMap", errorMsgMap);
			return "login";
		}
		return "loginSuccess"; //到時候要導到LoginSucess頁面
	}
	
	//以下為登出方法
	@GetMapping("/member/logout")
	public String memberLogout(HttpServletRequest request,HttpServletResponse response,Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("LoginOK");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			cookie.setValue(null);
            cookie.setMaxAge(0);// 立即销毁cookie
            cookie.setPath("/");
            response.addCookie(cookie);
		}
		return "redirect:/";
	}
	
	

}
