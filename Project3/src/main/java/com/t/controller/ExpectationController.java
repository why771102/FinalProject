//package com.t.controller;
//
//import javax.servlet.ServletContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.t.model.ExpectationBean;
//import com.t.service.ExpectationService;
//
//@Controller
//public class ExpectationController {
//	ExpectationService service;
//	ServletContext context;
//	
//	@Autowired
//	public void setContext(ServletContext context) {
//		this.context = context;
//	}
//
//	@Autowired
//	public void setService(ExpectationService service) {
//		this.service = service;
//	}
//	
//	@RequestMapping("/expectationGetMovieID")
//	public String getMovieById(@RequestParam("movieID") Integer movieID, Model model) {
//		model.addAttribute("movie", service.getMovieById(movieID));
//		return "movieID";
//	}
//	
//	@RequestMapping("/expectationGetMemberID")
//	public String getMemberById(@RequestParam("id") Integer memberID, Model model) {
//		model.addAttribute("member", service.getMovieById(memberID));
//		return "memberID";
//	}
//	
//	@RequestMapping(value = "/expectation/add", method = RequestMethod.GET)
//	public String getAddNewExpection(Model model) {
//		ExpectationBean eb = new ExpectationBean();
//		model.addAttribute("ExpectationBean",eb);
//		return "t/addExpection";		
//	}
//	
//	@RequestMapping(value = "/expection/add", method = RequestMethod.POST)
//	public String processAddNewExpection(@ModelAttribute("ExpectionBean") ExpectationBean eb) {
//		service.addExpect(eb);
//		return "redirect:/addExpectation";
//	}
//}
