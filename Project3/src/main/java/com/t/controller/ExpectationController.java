package com.t.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.t.model.ExpectationBean;
import com.t.service.ExpectationService;

@Controller
public class ExpectationController {
	ExpectationService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ExpectationService service) {
		this.service = service;
	}
	
	//查詢並列出電影ID們
	@RequestMapping("/getMovieIDforexpect")
	public String seleteMovieID(Model model) {
		List<String> list=service.getMovies();
		model.addAttribute("movieIDList", list);
		return "t/selectmovieIDforexpect";
	}
	
	//查詢並列出電影ID們
	@RequestMapping("/getMovieIDaddexpect")
	public String getMovieID(Model model) {
		List<String> list=service.getMovies();
		model.addAttribute("movieIDList", list);
		return "t/addexpectbymovieID";
	}
	
	//用movieID查詢expectation
	@RequestMapping("/expectation/{movieID}")
	public String getCommentByMovie(@PathVariable("movieID")Integer movieID,Model model) {
		List<ExpectationBean> expect=service.getExpectationByMovie(movieID);
		model.addAttribute("Expectations", expect);
		return "t/expectationbymovie";
	}
	
	@RequestMapping("/expectationGetMovieID")
	public String getMovieById(@RequestParam("movieID") Integer movieID, Model model) {
		model.addAttribute("movie", service.getMovieById(movieID));
		return "movieID";
	}
	
	@RequestMapping("/expectationGetMemberID")
	public String getMemberById(@RequestParam("id") Integer memberID, Model model) {
		model.addAttribute("member", service.getMovieById(memberID));
		return "memberID";
	}
	
	@RequestMapping(value = "/expectation/add/{movieID}", method = RequestMethod.GET)
	public String getAddNewExpection(Model model) {
		ExpectationBean eb = new ExpectationBean();
		model.addAttribute("ExpectationBean",eb);
		return "t/addexpectation";
	}
	
	@RequestMapping(value = "/expection/add/{movieID}", method = RequestMethod.POST)
	public String processAddNewExpection(@PathVariable("movieID")Integer movieID, @ModelAttribute("ExpectionBean") ExpectationBean eb) {
		eb.setMovieID(movieID);
		service.addExpect(eb);
		return "redirect:/selectmovieIDforexpect";
	}
	
}
