package com.l.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
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
		//連接購普通票畫面
		@RequestMapping("/bookNormal")
		public String bookNormal(){
			return "l/bookNormal";
		}
		
		//連接確定畫面並用cookie顯示購買資訊
		@RequestMapping("/orderconfirm")
		public String orderconfirm(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("showtimeId")) {
				 String value=cookie.getValue();
				 ShowTimeHistoryBean sthb=(ShowTimeHistoryBean) service.getStartTimeByID(Integer.parseInt(value));
				 model.addAttribute("queryStartTime",sthb);
			}
		}
		
		return "l/orderconfirm";
		}
		
		//將cookie寫到order、orderdetail資料表,並且削掉cookie
		
		@RequestMapping("/orderconfirmOK")
		public String orderconfirmOK(Model model,HttpServletRequest request,HttpServletResponse response){
			MOrderBean mb=new MOrderBean();
			HttpSession session = request.getSession();
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("showtimeId")) {
					 String showtimeId=cookie.getValue();
					 System.out.println(showtimeId+"123");
					 mb.setShowTimeID(Integer.parseInt(showtimeId));
					 }
				if(cookie.getName().equals("memberID")) {
						 String memberID=cookie.getValue();
						 mb.setMemberID(Integer.parseInt(memberID));
				}else{
					mb.setMemberID(1);
				}
			}
			LocalDate today = (LocalDate.now());
			LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
			String dateTime = today.toString() + " " + time.toString();
			mb.setOrderTime(dateTime);
			mb.setTicketStatus(0);
			mb.setTicketTime("2999-01-01");
			mb.setEmpId(1);
			service.addMOrder(mb);
			return "l/orderconfirmOK";
		}




}