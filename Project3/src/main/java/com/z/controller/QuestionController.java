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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.z.model.QuestionBean;
import com.z.model.QuestionContentBean;
import com.z.service.QuestionContentService;
import com.z.service.QuestionService;

@Controller
public class QuestionController {

	QuestionService service;
	QuestionContentService ConService;

	ServletContext context;

//	@Autowired
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

	// 透過用戶ID查詢客服紀錄
	@RequestMapping(value = "/questionList")
	public String getAllQuestion(Model model, HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		Integer memberId = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
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
			if (name.equals("memberID")) {
				memberId = Integer.parseInt(cookie.getValue());
			}
		}
		if (memberId == null) {
			return "login";
		}
		Integer questionId = service.newQuestion(memberId);
		model.addAttribute("questionId", questionId);
		return "redirect:/question/" + questionId;
	}

	// 進到專屬客服區，用戶用
	@RequestMapping(value = "/question/{questionId}")
	public String ques(Model model, HttpServletRequest request, @PathVariable("questionId") Integer questionId) {

		// 前往聊天室的路徑，先判斷是不是同一個人
		Cookie[] cookies = request.getCookies();
		Integer memberId = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
				memberId = Integer.parseInt(cookie.getValue());
			}
		}
		if (!service.checkMember(memberId, questionId)) {
			return "z/questionList"; // 表示驗證沒過，不是同一個用戶
		}
		// 查詢歷史訊息
		List<QuestionContentBean> list = ConService.historyContent(questionId);
		System.out.println("size : " + list.size());
		model.addAttribute("content", list);
		System.out.println(list);
		QuestionBean qb = service.question(questionId);
		Integer status = qb.getQuestionStatusBean().getStatus();
		model.addAttribute("status", status);
		System.out.println("status = " + status);
		return "z/websocket";

	}

	// 查詢所有客服
	@RequestMapping(value = "/questionListForEmp")
	public String getAllQuestionForEmp(Model model, HttpServletRequest request) {

		List<QuestionBean> allQuestion = service.allQuestionForEmp();
		model.addAttribute("allQuestion", allQuestion);
		return "z/questionListForEmp";
	}

	@RequestMapping(value = "/questionListForEmpAjax", produces = "application/json;charset=UTF-8;")
	public @ResponseBody String getAllQuestionForEmpAjax(Model model, HttpServletRequest request) {

		List<QuestionBean> allQuestion = service.allQuestionForEmp();
		model.addAttribute("allQuestion", allQuestion);
		Gson gson = new Gson();
		String list = gson.toJson(allQuestion);
		return list;
	}

	@RequestMapping(value = "/questionRep/{questionId}")
	public String quesForEmp(Model model, HttpServletRequest request, @PathVariable("questionId") Integer questionId) {

		// 查詢歷史訊息
		List<QuestionContentBean> list = ConService.historyContent(questionId);
		System.out.println("size : " + list.size());
		model.addAttribute("content", list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getContent());
		}
		System.out.println(list);
		QuestionBean qb = service.question(questionId);
		Integer status = qb.getQuestionStatusBean().getStatus();
		model.addAttribute("status", status);
		System.out.println("status = " + status);
		return "z/websocketForEmp";

	}

	@RequestMapping(value = "/closeQuestion")
	public @ResponseBody String closeQuestion(Integer questionId) {
		System.out.println("questionId = " + questionId);
		try {
			service.closeQuestion(questionId);
			return "sucess";
		} catch (Exception e) {
			return "fail";
		}
	}
	
	@RequestMapping(value = "/openQuestion")
	public @ResponseBody String openQuestion(Integer questionId) {
		System.out.println("questionId = " + questionId);
		
		service.openQuestion(questionId);
		return "sucess";

	}

}
