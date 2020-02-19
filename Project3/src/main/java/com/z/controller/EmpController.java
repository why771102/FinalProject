package com.z.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.z.model.EmpBean;
import com.z.service.EmpService;

@Controller
public class EmpController {
	
	EmpService service;
	ServletContext context;
	
//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(EmpService service) {
		this.service = service;
	}
	
	//以下為導入登入頁面的controller
	@RequestMapping(value="/emp/login", method = RequestMethod.GET)
	public String login(Model model){
		EmpBean eb = new EmpBean();
		model.addAttribute("empBean",eb);
		return "z/EmpLogin";
	}
	
	//以下為判斷登入的方法
	@RequestMapping(value="/emp/login", method = RequestMethod.POST)
	public String logincheck(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("empBean")EmpBean eb,Model model) {
		HttpSession session = request.getSession();
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		if(eb.getEmail() == null || eb.getEmail().trim().length() == 0) {
			errorMsgMap.put("IDError","請輸入帳號");
		}
		if(eb.getPassword() == null || eb.getPassword().trim().length() == 0) {
			errorMsgMap.put("pwdError","請輸入密碼");
		}
		
		if(!errorMsgMap.isEmpty()) {
			model.addAttribute("errorMsgMap", errorMsgMap);
			return "z/EmpLogin";
		}
		
		EmpBean eb2 = service.login(eb.getEmail(), eb.getPassword());
		if(eb2 != null) {
			//登入成功，將mb2物件放進session範圍中，識別字串為EmpLogin
			session.setAttribute("EmpLogin", eb2);
			
			Cookie cookie = new Cookie("role",eb2.getRoleBean().getRoleId().toString());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("EmpName",eb2.getEmpName());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("EmpID",eb2.getEmpId().toString());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		}else {
			errorMsgMap.put("IDPwdError","帳號或密碼錯誤，請重新輸入!");
		}
		if(!errorMsgMap.isEmpty()) {
			model.addAttribute("errorMsgMap", errorMsgMap);
			return "z/EmpLogin";
		}
		return "redirect:/backstageindex"; //到時候要導到LoginSucess頁面
	}
	
	//以下為登出方法
	@GetMapping("/emp/logout")
	public String EmpLogout(HttpServletRequest request,HttpServletResponse response,Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("EmpLogin");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			cookie.setValue(null);
            cookie.setMaxAge(0);// 立即销毁cookie
            cookie.setPath("/");
            response.addCookie(cookie);
		}
		return "redirect:/emp/login";
	}
	
	
	@RequestMapping(value = "/emp/updatePwd", method = RequestMethod.GET)
	public String updateEmpPwd(Model model, HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		Integer empId = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("EmpID")) {
				empId = Integer.parseInt(cookie.getValue());
			}
		}
		EmpBean ab = service.getEmp(empId);
		
		model.addAttribute("empBean", ab);
		//試著加上是否為員工本人的判斷，導向不同頁面
		return "z/updatePwd";
	}
	
	
	@RequestMapping(value = "/emp/updatePwd", method = RequestMethod.POST)
	public String processUdateEmpPwd(Model model, HttpServletRequest request, @ModelAttribute("empBean") EmpBean eb) {
		
		eb.setPassword(eb.getPwd());
		eb.setRoleId(eb.getRoleBean().getRoleId());
		eb.setStatus(eb.getEmpStatusBean().getStatus());
		service.changePwd(eb);
		return "redirect:/emps";
	}
	

}
