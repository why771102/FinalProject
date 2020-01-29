package com.z.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.z.model.QuestionBean;
import com.z.model.QuestionContentBean;
import com.z.service.QuestionContentService;
import com.z.service.QuestionService;

@Controller
public class QuestionController {
	
	QuestionService service;
	QuestionContentService ConService;
	
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(QuestionService service) {
		this.service = service;
	}
	
	@Autowired
	public void setService(QuestionContentService service) {
		this.ConService = service;
	}
	
	//透過用戶ID查詢客服紀錄
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
		return "z/questionList";
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
		return "redirect:/question/" + questionId;	
	}
	
	
	//進到專屬客服區
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
		//查詢歷史訊息
		List<QuestionContentBean> list = ConService.historyContent(questionId);
		model.addAttribute("content", list);
		return "z/websocket";

	}
	
	
	
	
	
	
	

}
