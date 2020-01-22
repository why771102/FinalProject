package com.z.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.z.model.AnnoBean;
import com.z.model.AnnoStatusBean;
import com.z.model.QuestionBean;
import com.z.service.AnnoService;
import com.z.service.QuestionService;

@Controller
public class QuestionController {
	
	QuestionService service;
	
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(QuestionService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/questionList")
	public String getAllQuestion(Model model, HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		Integer memberId = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				memberId = Integer.parseInt(cookie.getValue());
			}
		}
		List<QuestionBean> allQuestion = service.allQuestion(memberId);
		model.addAttribute("allQuestion", allQuestion);
		return "z/QuestionList";
	}
	
	
	@RequestMapping(value = "/question")
	public String newQues(Model model, HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		Integer memberId = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				memberId = Integer.parseInt(cookie.getValue());
			}
		}
		Integer questionId = service.newQuestion(memberId);
		model.addAttribute("questionId", questionId);
		return null;	
	}
	
	
	@RequestMapping(value = "/question/{questionId}")
	public String ques(Model model, HttpServletRequest request, @PathVariable("questionId") Integer questionId) {
		
		//前往聊天室的路徑，先判斷是不是同一個人
		Cookie[] cookies = request.getCookies();
		Integer memberId = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				memberId = Integer.parseInt(cookie.getValue());
			}
		}
		if(!service.checkMember(memberId, questionId)) {
			return null;    //表示驗證沒過，不是同一個用戶
		}
		
		
		
		
		
		return null;
	}
	
	
	
	
	
	
	

}
