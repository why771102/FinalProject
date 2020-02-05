package com.l.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.google.gson.Gson;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.l.service.mOrdersService;
import com.z.model.EmpBean;


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
		public String bookNormal(@ModelAttribute("showtime") ShowTimeHistoryBean sthb, Model model){
			model.addAttribute("showtime", sthb);
			return "l/bookNormal";
		}
		
		//連接確定畫面並用cookie顯示購買資訊
		@RequestMapping("/orderconfirm")
		public String orderconfirm(Model model,HttpServletRequest request,HttpServletResponse response,
				@ModelAttribute("showtime") ShowTimeHistoryBean sthb){
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("showtimeId")) {
				 String value=cookie.getValue();
//				 ShowTimeHistoryBean sthb=(ShowTimeHistoryBean) service.getStartTimeByID(Integer.parseInt(value));
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
					 String showtimeId = cookie.getValue();
					 mb.setShowTimeID(Integer.parseInt(showtimeId));
					 }
				if(cookie.getName().equals("memberID")) {
					 String memberID = cookie.getValue();
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
			
			MOrderDetailBean mdb=new MOrderDetailBean();
			MOrderDetailBean mdb1=new MOrderDetailBean();
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("discount")) {
					 String discount = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(13);
					 mdb.setSellUnitPrice(195);
					 mdb.setDiscount(1.0);
					 mdb.setQuantity(Integer.parseInt(discount));
					 service.addMOrderDetail(mdb); 
					 mdb1.setOrdersID(mb.getOrdersID());
					 mdb1.setProductID(14);
					 mdb1.setSellUnitPrice(175);
					 mdb1.setDiscount(1.0);
					 mdb1.setQuantity(Integer.parseInt(discount));
					 service.addMOrderDetail(mdb1); 
					 session.removeAttribute("discount");
					 Cookie killMyCookie = new Cookie("discount", null);
		             killMyCookie.setMaxAge(0);
		             killMyCookie.setPath("/");
		             response.addCookie(killMyCookie);
	
				}
				if(cookie.getName().equals("discount2")) {
					 String discount2 = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(15);
					 mdb.setSellUnitPrice(370);
					 mdb.setDiscount(1.0);
					 mdb.setQuantity(Integer.parseInt(discount2));
					 service.addMOrderDetail(mdb);
					 mdb1.setOrdersID(mb.getOrdersID());
					 mdb1.setProductID(16);
					 mdb1.setSellUnitPrice(330);
					 mdb1.setDiscount(1.0);
					 mdb1.setQuantity(Integer.parseInt(discount2));
					 service.addMOrderDetail(mdb1); 
					 session.removeAttribute("discount2");
				}
				if(cookie.getName().equals("bankticket")) {
					 String bankticket = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(3);
					 mdb.setSellUnitPrice(220);
					 mdb.setDiscount(1.0);
					 mdb.setQuantity(Integer.parseInt(bankticket));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("bankticket");
					}
				if(cookie.getName().equals("normal")) {
					 String normal = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(1);
					 mdb.setSellUnitPrice(290);
					 mdb.setDiscount(1.0);
					 mdb.setQuantity(Integer.parseInt(normal));
					 service.addMOrderDetail(mdb); 
					 session.removeAttribute("normal");
					}
				if(cookie.getName().equals("hotdog")) {
					 String hotdog = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(7);
					 mdb.setSellUnitPrice(120);
					 mdb.setDiscount(0.9);
					 mdb.setQuantity(Integer.parseInt(hotdog));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("hotdog");
				}
				if(cookie.getName().equals("churro")) {
					 String churro = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(8);
					 mdb.setSellUnitPrice(100);
					 mdb.setDiscount(0.9);
					 mdb.setQuantity(Integer.parseInt(churro));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("churro");
					 }
				if(cookie.getName().equals("friedChicken")) {
					 String friedChicken = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(9);
					 mdb.setSellUnitPrice(200);
					 mdb.setDiscount(0.9);
					 mdb.setQuantity(Integer.parseInt(friedChicken));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("friedChicken");
					 }
				if(cookie.getName().equals("bigCoke")) {
					 String bigCoke = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(4);
					 mdb.setSellUnitPrice(70);
					 mdb.setDiscount(0.9);
					 mdb.setQuantity(Integer.parseInt(bigCoke));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("bigCoke");
					 }
				if(cookie.getName().equals("normalCoke")) {
					 String normalCoke = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(5);
					 mdb.setSellUnitPrice(60);
					 mdb.setDiscount(0.9);
					 mdb.setQuantity(Integer.parseInt(normalCoke));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("normalCoke");
					 }
				if(cookie.getName().equals("smallCoke")) {
					 String smallCoke = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(6);
					 mdb.setSellUnitPrice(54);
					 mdb.setDiscount(0.9);
					 mdb.setQuantity(Integer.parseInt(smallCoke));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("smallCoke");
					 }
				if(cookie.getName().equals("bigPopcorn")) {
					 String bigPopcorn = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(10);
					 mdb.setSellUnitPrice(140);
					 mdb.setDiscount(0.9);
					 mdb.setQuantity(Integer.parseInt(bigPopcorn));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("bigPopcorn");
					 }
				if(cookie.getName().equals("normalPopcorn")) {
					 String normalPopcorn = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(11);
					 mdb.setSellUnitPrice(130);
					 mdb.setDiscount(0.9);
					 mdb.setQuantity(Integer.parseInt(normalPopcorn));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("normalPopcorn");
					 }
				if(cookie.getName().equals("smallPopcorn")) {
					 String smallPopcorn = cookie.getValue();
					 mdb.setOrdersID(mb.getOrdersID());
					 mdb.setProductID(12);
					 mdb.setSellUnitPrice(120);
					 mdb.setDiscount(0.9);
					 mdb.setQuantity(Integer.parseInt(smallPopcorn));
					 service.addMOrderDetail(mdb);
					 session.removeAttribute("smallPopcorn");
				}
					cookie.setValue(null);
		            cookie.setMaxAge(0);
		            cookie.setPath("/");
		            response.addCookie(cookie);
				
			}
			
			return "l/orderconfirmOK";
		}

		//輸入訂單號碼頁面
		@RequestMapping("/inputOrderID")
		public String inputOrderID(Model model) {
		return "l/inputOrderID";
		}
		
		//查詢單筆資料
		@RequestMapping("/searchTicket")
		public String queryTicket(@RequestParam("orderID") Integer orderID,Model model) {
			MOrderBean mb = service.getOrderID(orderID);
			model.addAttribute("getOrderByID",mb);
			return "l/queryTicket";
		}
		
		//修改訂單時間
		@RequestMapping(value ="/updateTicket/{orderID}", method = RequestMethod.GET)
		public String updateTicket(Model model, @PathVariable("orderID") Integer orderID){
			MOrderBean mb = service.getOrderID(orderID);
			model.addAttribute("MOrderBean", mb);
			return "l/updateTicket";
		}
		
		@RequestMapping(value ="/updateTicket/{orderID}", method = RequestMethod.POST)
		public String updateTicket2(@ModelAttribute("MOrderBean") MOrderBean mb,Model model){
			service.updateTicket(mb);
			model.addAttribute("getOrderByID",service.getOrderID(mb.getOrdersID()));
			return "l/queryTicket";
		}
		
		
		
		//假資料
		@RequestMapping("/fakeTicket")
		public String fakeTicket(){
			MOrderBean mb=new MOrderBean();
			MOrderDetailBean mdb=new MOrderDetailBean();
			for(int i=1;i<=5078;i++) {
				mb.setShowTimeID(i);
				ShowTimeHistoryBean sthb=(ShowTimeHistoryBean) service.getStartTimeByID(i);
				mb.setOrderTime(sthb.getPlayStartTime().substring(0,sthb.getPlayStartTime().length()-11));
				String hall = sthb.getHall().getHallID();
				mb.setTicketStatus(0);
				mb.setTicketTime("2999-01-01");
				mb.setEmpId(1);
				mb.setMemberID(1);
				service.addMOrder(mb);
				if(hall.equals("A")) {
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(1);
					mdb.setSellUnitPrice(290);
					mdb.setDiscount(1.0);
					// (int)(Math.random()*(總共幾個數字))+(最小值)
					mdb.setQuantity((int)(Math.random()*21+126));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(13);
					mdb.setSellUnitPrice(195);
					mdb.setDiscount(1.0);
					int A=(int)(Math.random()*25+25);
					mdb.setQuantity(A);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(14);
					mdb.setSellUnitPrice(175);
					mdb.setDiscount(1.0);
					mdb.setQuantity(A);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(11);
					mdb.setSellUnitPrice(130);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*30+20));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(5);
					mdb.setSellUnitPrice(60);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*30+15));
					service.addMOrderDetail(mdb);
				}
				if(hall.equals("B")) {
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(1);
					mdb.setSellUnitPrice(290);
					mdb.setDiscount(1.0);
					mdb.setQuantity((int)(Math.random()*36+72));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(15);
					mdb.setSellUnitPrice(350);
					mdb.setDiscount(1.0);
					int B=(int)(Math.random()*25+25);
					mdb.setQuantity(B);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(16);
					mdb.setSellUnitPrice(330);
					mdb.setDiscount(1.0);
					mdb.setQuantity(B);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(12);
					mdb.setSellUnitPrice(120);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*20+20));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(5);
					mdb.setSellUnitPrice(60);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*20+15));
					service.addMOrderDetail(mdb);
				}
				if(hall.equals("C")) {
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(1);
					mdb.setSellUnitPrice(290);
					mdb.setDiscount(1.0);
					mdb.setQuantity((int)(Math.random()*21+126));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(13);
					mdb.setSellUnitPrice(195);
					mdb.setDiscount(1.0);
					int C=(int)(Math.random()*20+25);
					mdb.setQuantity(C);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(14);
					mdb.setSellUnitPrice(175);
					mdb.setDiscount(1.0);
					mdb.setQuantity(C);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(11);
					mdb.setSellUnitPrice(130);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*30+15));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(5);
					mdb.setSellUnitPrice(60);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*25+20));
					service.addMOrderDetail(mdb);
				}
				if(hall.equals("D")) {
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(1);
					mdb.setSellUnitPrice(290);
					mdb.setDiscount(1.0);
					mdb.setQuantity((int)(Math.random()*24+192));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(13);
					mdb.setSellUnitPrice(195);
					mdb.setDiscount(1.0);
					int D=(int)(Math.random()*10+10);
					mdb.setQuantity(D);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(14);
					mdb.setSellUnitPrice(175);
					mdb.setDiscount(1.0);
					mdb.setQuantity(D);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(8);
					mdb.setSellUnitPrice(100);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*30+25));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(6);
					mdb.setSellUnitPrice(54);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*30+20));
					service.addMOrderDetail(mdb);
				}
				if(hall.equals("E")) {
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(1);
					mdb.setSellUnitPrice(290);
					mdb.setDiscount(1.0);
					mdb.setQuantity((int)(Math.random()*40+58));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(7);
					mdb.setSellUnitPrice(120);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*10+10));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(4);
					mdb.setSellUnitPrice(70);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*15+10));
					service.addMOrderDetail(mdb);
				}
				if(hall.equals("F")) {
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(1);
					mdb.setSellUnitPrice(290);
					mdb.setDiscount(1.0);
					mdb.setQuantity((int)(Math.random()*26+204));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(13);
					mdb.setSellUnitPrice(195);
					mdb.setDiscount(1.0);
					int F=(int)(Math.random()*10+10);
					mdb.setQuantity(F);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(14);
					mdb.setSellUnitPrice(175);
					mdb.setDiscount(1.0);
					mdb.setQuantity(F);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(9);
					mdb.setSellUnitPrice(200);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*20+40));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(6);
					mdb.setSellUnitPrice(54);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*25+35));
					service.addMOrderDetail(mdb);
				}
				if(hall.equals("G")) {
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(1);
					mdb.setSellUnitPrice(290);
					mdb.setDiscount(1.0);
					mdb.setQuantity((int)(Math.random()*20+120));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(15);
					mdb.setSellUnitPrice(350);
					mdb.setDiscount(1.0);
					mdb.setQuantity(15);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(16);
					mdb.setSellUnitPrice(330);
					mdb.setDiscount(1.0);
					mdb.setQuantity(15);
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(10);
					mdb.setSellUnitPrice(140);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*25+25));
					service.addMOrderDetail(mdb);
					mdb.setOrdersID(mb.getOrdersID());
					mdb.setProductID(5);
					mdb.setSellUnitPrice(60);
					mdb.setDiscount(0.9);
					mdb.setQuantity((int)(Math.random()*20+30));
					service.addMOrderDetail(mdb);
				}
				
			}
			return "l/fakeTicket";
		}

}