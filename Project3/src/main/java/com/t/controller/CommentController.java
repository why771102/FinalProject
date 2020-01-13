package com.t.controller;

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

import com.a.model.MovieBean;
import com.l.model.ProductsBean;
import com.p.model.MemberBean;
import com.t.model.CommentBean;
import com.t.service.CommentService;
import com.z.model.EmpStatusBean;

@Controller
public class CommentController {

	CommentService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(CommentService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/comments/add", method = RequestMethod.GET)
	public String getAddNewComment(Model model) {
		CommentBean cb = new CommentBean();
		model.addAttribute("commentBean",cb);
		return "addComment";		
	}
	
	@RequestMapping(value = "/comments/add", method = RequestMethod.POST)
	public String processAddNewComment(@ModelAttribute("CommentBean") CommentBean cb) {
		service.addComment(cb);
		return "redirect:/comment";	
	}
	
	@ModelAttribute("movieList")
	public Map<Integer, String> getMovieList() {
		Map<Integer, String> MovieMap = new HashMap<>();
		List<MovieBean> list = service.getMovieList();
		for (MovieBean mb : list) {
			MovieMap.put(mb.getMovieID(),mb.getTitle());
		}
		return MovieMap;
	}
	
	@ModelAttribute("memberList")
	public Map<Integer, String> getMemberList() {
		Map<Integer, String> MemberMap = new HashMap<>();
		List<MemberBean> list = service.getMemberList();
		for (MemberBean mb : list) {
			MemberMap.put(mb.getMemberID(),mb.getAccount());
		}
		return MemberMap;
	}
}
