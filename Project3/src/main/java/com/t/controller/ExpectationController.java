package com.t.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.a.model.RunningBean;
import com.a.service.MovieService;
import com.t.model.ExpectationBean;
import com.t.service.ExpectationService;
import com.t.validator.ExpectationValidator;

@Controller
public class ExpectationController {
	ExpectationService service;
	MovieService mService;
	ServletContext context;

//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ExpectationService service, MovieService mService) {
		this.service = service;
		this.mService = mService;
	}

	// 查詢並列出電影ID們
	@RequestMapping("/getMovieIDforexpect")
	public String seleteMovieID(Model model) {
		List<String> list = service.getMovies();
		model.addAttribute("movieIDList", list);
		return "t/selectmovieIDforexpect";
	}

	// 查詢並列出未上映電影ID們
	@RequestMapping("/getMovieIDaddexpect")
	public String getMovieID(Model model) {
		List<String> list = service.getStandbyMovies();
		model.addAttribute("movieIDList", list);
		return "t/addexpectbymovieID";
	}

	// 用movieID查詢expectation
	@RequestMapping("/expectation/{movieID}")
	public String getExpectationByMovie(@PathVariable("movieID") Integer movieID, Model model) {
		Integer avgExpectation = service.getAvgExpectation(movieID);
		if (avgExpectation == null) {
			model.addAttribute("AVGExpectation", "");
		} else {
			model.addAttribute("AVGExpectation", avgExpectation + "%期待");
		}
		List<ExpectationBean> expect = service.getExpectationByMovie(movieID);
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

//	@RequestMapping(value = "/expectation/add/{runID}", method = RequestMethod.GET)
//	public String getAddNewExpection(@PathVariable("runID") String runID,Model model) {
//		ExpectationBean eb = new ExpectationBean();
//		System.out.println("runID = " + runID);
//		model.addAttribute("ExpectationBean",eb);
//		return "redirect:/expectation/add/post/{runID}";
//	}

	@RequestMapping(value = "/expectation/add/{runID}", method = RequestMethod.POST)
	public String processAddNewExpection(@PathVariable("runID") String runID, @ModelAttribute("ExpectationBean")ExpectationBean eb, BindingResult result,
			HttpServletRequest request) {
		HashMap<String, String> errorMsgMap = new HashMap<String, String>();
		RunningBean run = mService.getRunningBeanById(runID);
		ExpectationValidator validator = new ExpectationValidator();
		// 呼叫Validate進行資料檢查
		validator.validate(eb, result);
		if (result.hasErrors()) {
			return "redirect:/show/this/movie/commingSoon?runID=" + runID;
		}
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		if (mID == null) {
			return "redirect:/member/login";
		} else {
			int movieID = run.getMovie().getMovieID();
			int nMID = Integer.parseInt(mID);
			boolean ee = service.checkExpectationExist(nMID, movieID);
			if (ee == true) {
				errorMsgMap.put("expectExistError", "無法多次填寫!");
			} else {
				eb.setMovieID(movieID);
				eb.setMemberID(nMID);
				service.addExpect(eb);
			}
		}
		return "redirect:/show/this/movie/commingSoon?runID=" + runID;
	}

//	@RequestMapping(value = "/addnewexpect/{runID}", method = RequestMethod.GET)
//	public String getAddNewExpect(@PathVariable("runID") String runID,Model model) {
//		System.out.println("runID = " + runID);
//		ExpectationBean eb = new ExpectationBean();
//		model.addAttribute("ExpectationBean",eb);
//		return "redirect:/addnewexpect/"+ runID;
//	}
//
//	
//	@RequestMapping(value = "/addnewexpect/{runID}" , method = RequestMethod.POST)
//	public String processAddNewExpect(@PathVariable("runID") String runID,ExpectationBean eb,BindingResult result,HttpServletRequest request) {
//		HashMap<String, String> errorMsgMap = new HashMap<String, String>();
//		RunningBean run = mService.getRunningBeanById(runID);
////		ExpectationBean eb = new ExpectationBean();
//		ExpectationValidator validator = new ExpectationValidator();
//		// 呼叫Validate進行資料檢查
//		validator.validate(eb, result);
//		if (result.hasErrors()) {
//			return "redirect:a/showMovie3";
//		}
//		Cookie[] cookies = request.getCookies();
//		String mID = null;
//		for (Cookie cookie : cookies) {
//			String name = cookie.getName();
//			if(name.equals("memberID")) {
//				mID = cookie.getValue();
//			}
//		}
//		if(mID == null) {
//			return "redirect:/member/login";
//		}else {
//			int nMID = Integer.parseInt(mID);
//			eb.setMemberID(nMID);
//			int movieID = run.getMovie().getMovieID();
//			System.out.println("movieID = " + movieID);
//			boolean ee = service.checkExpectationExist(nMID, movieID);
//			if(ee == true) {
//				errorMsgMap.put("accountExistError", "無法多次填寫!");
//			}else {
//				eb.setMovieID(movieID);
//				service.addExpect(eb);
//			}			
//		}
//		System.out.println("檢查點" + 000);
//		return "redirect:/show/this/movie/commingSoon?runID" + runID;
//	}

//	@ModelAttribute("memberList")
//	public Map<Integer, String> getMemberList() {
//		Map<Integer, String> MemberMap = new HashMap<>();
//		List<MemberBean> list = service.getMemberList();
//		for (MemberBean mb : list) {
//			MemberMap.put(mb.getMemberID(),mb.getAccount());
//		}
//		return MemberMap;
//	}

//	@ModelAttribute("ExpectationBean")
//	public ExpectationBean getExpectationBean() {
//		ExpectationBean eb = new ExpectationBean();		
//		return eb;
//	}
}
