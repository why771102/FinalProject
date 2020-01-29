package com.l.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.ProductsBean;
import com.l.service.mOrdersService;


@Controller
public class mOrdersController {
	mOrdersService service;
	@Autowired
	public void setService(mOrdersService service) {
		this.service = service;
	}

	//查詢所有running電影限定時間
	@RequestMapping("/queryMovie") 
	public String showAllMovie(Model model,HttpServletRequest request,HttpServletResponse response) {
		LocalDate today = (LocalDate.now());
		LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		String dateTime = today.toString() + " " + time.toString();
		List<RunningBean> rb = service.getAllOnMoive(today);
		model.addAttribute("AllMovies", rb);   
 		return "l/movie";
	}
	
	//查詢多個playStartTime
	@RequestMapping("/queryStartTimes/{runID}") 
		public String queryStartTime(@PathVariable("runID")Integer runID,String exOffDay,Model model,HttpServletRequest request,HttpServletResponse response) {
			
			LocalDate today = (LocalDate.now());
			LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
			String dateTime = today.toString() + " " + time.toString();
			RunningBean rb=service.getDayAndRelease(runID);
			exOffDay=rb.getExpectedOffDate();
			List<ShowTimeHistoryBean> sthb=service.getplayStartTime(runID,dateTime,exOffDay);
			model.addAttribute("playStartTime",sthb);
			
			return "l/queryStartTimes";
		}
	
	
		//查詢一個playStartTime並設定cookie
		@RequestMapping("/queryStartTime") 
		public String queryStartTimeByID(@RequestParam("showTimeId")Integer showTimeId,Model model,HttpServletRequest request,HttpServletResponse response) {
		
			HttpSession session = request.getSession();
			ShowTimeHistoryBean sthb=(ShowTimeHistoryBean) service.getStartTimeByID(showTimeId);
			model.addAttribute("queryStartTime",sthb);

			session.setAttribute("ShowTimeHistory", sthb);
			Cookie cookie = new Cookie("showtimeId",sthb.getShowTimeId().toString());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);

//			時間有空格問題
//		    cookie = new Cookie("playStartTime",sthb.getPlayStartTime());
//		    cookie.setMaxAge(7 * 24 * 60 * 60);
//		    cookie.setPath("/");
//		    response.addCookie(cookie);
//		    
//		    cookie = new Cookie("hallID",sthb.getHall().getHallID());
//		    cookie.setMaxAge(7 * 24 * 60 * 60);
//		    cookie.setPath("/");
//		    response.addCookie(cookie);
//
//		    cookie = new Cookie("runID",sthb.getRun().getRunID().toString());
//		    cookie.setMaxAge(7 * 24 * 60 * 60);
//		    cookie.setPath("/");
//		    response.addCookie(cookie);
		    
			return "l/queryStartTime";
		}

		//連接購票畫面
		@RequestMapping("/buyticket")
		public String buyTicket(){
			return "l/tickets";
		}
		//連接購票畫面
		@RequestMapping("/bookNormal")
		public String bookNormal(){
			return "l/bookNormal";
		}
		
		
		
		
//	//用電影ID查詢所有RUNID時間在release和expectedOffDate之間
//	@RequestMapping("/queryMovie")
//	public String getRunningID(Model model,HttpServletRequest request,HttpServletResponse response){
//		LocalDate today = (LocalDate.now());
//		LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
//		String dateTime = today.toString() + " " + time.toString();
//		List<RunningBean> list=service.getRunningID();
//		model.addAttribute("AllMovies", list);
//		return "l/Movie";
//	}
	
	
	//	//查詢所有電影之狀態為1
//	@RequestMapping("/queryMovie")
//	public String getMovieStatus1(Model model) {
//		List<MovieBean> list=service.getMovieStatus1();
//		model.addAttribute("AllMovies", list);
//		return "l/Movie";
//	}
//	
//	@ResponseBody
//	@RequestMapping("/morders/{movieID}")
//	public List<ShowTimeHistoryBean> getPlayStartTime(@PathVariable("movieID") Integer movieID) {
//
//		// 用movieId查runningBean但只要一個runID
//		List<Integer> runninglist =new ArrayList<>();
//		List <RunningBean> runningBean= service.getRunningsByMovieId(movieID);
//		for(RunningBean rb:runningBean) {
//			runninglist.add(rb.getRunID());
//		}
//		
//		// 用runningId查ShowTimeHistoryBean
//		List<ShowTimeHistoryBean> sthb =service.getplayStartTime(runninglist.get(0));
//		
//		// 返回一串PlayStartTime
//		return sthb;
//		
//		
//	}

	
	
	
}
