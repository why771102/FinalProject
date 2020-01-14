package com.a.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.c.model.HallBean;
import com.c.service.HallService;

@Controller
public class RunMovieController {
	ServletContext context;
	MovieService mService;
	HallService hService;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(MovieService mService, HallService hService) {
		this.mService = mService;
		this.hService = hService;
	}
	
	//新增電影方法
	
		@GetMapping(value = "/movie/add")//URL
		public String proceessAdd(Model model) {
			MovieBean mb = new MovieBean();
			
			//傳空的Bean去前端//如果controller有資料要
			model.addAttribute("Movie", mb);
		
			return "a/addMovie";
		}
		
		@PostMapping(value = "/movie/add")
		public RedirectView addNewMove(Model model, @ModelAttribute("Movie") MovieBean mb,
				                       BindingResult result, HttpServletRequest request
				                       ,@RequestParam("release")String release
				                       ,@RequestParam("expectedOffDate")String expectedOffDate
				                       ,@RequestParam("MustShowDay")String MustShowDay
		                               ){
			String url = request.getContextPath();
			System.out.println(url);
			String[] suppressedFields = result.getSuppressedFields();
			
			if(suppressedFields.length > 0) {
				throw new RuntimeException("傳入不允許的欄位");
			} 
			mb.setStatus(0);
//			System.out.println("title:"+mb.getTitle()+"合約:"+mb.getContractDate()+"預估 :"+mb.getExpectedProfit()
//			                   +"拆帳:"+mb.getProfitRatio()+"狀態:"+mb.getStatus()+"片長:"+mb.getRunningTime()
//					);
//			System.out.println("導演:"+mb.getDirector()+"演員:"+mb.getCast()+"預告"+mb.getTrailer()
//			                    +"類型"+mb.getGenre()+"分級:"+mb.getMovieRating()+"內容:"+mb.getPlotSummary()
//					);
			
	 		mService.addmovie(mb);
	 		
	 		//save RunningBean in SQL
	 	    DateTimeFormatter fmtD = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
	 	    LocalDate startDate = LocalDate.parse(release, fmtD);
	 	    LocalDate endDate = LocalDate.parse(expectedOffDate, fmtD);
	 	    long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
	 	    int totalDay =(int)(daysDiff);
	 	   
	 		RunningBean rb1 = new RunningBean();
//	 		int totalDay = Integer.parseInt(expectedOnDate);
	 		int mustDay =Integer.parseInt(MustShowDay);
	 		if(totalDay-mustDay >0 && mustDay!= 0) {
	 			RunningBean rb2 = new RunningBean(release,mustDay,0,expectedOffDate,"2999-01-01",0,mb);
	 			mService.addrunning(rb2);
	 		    rb1 = new RunningBean(release,(totalDay-mustDay),0,expectedOffDate,"2999-01-01",1,mb);
	 		}else if(mustDay==0 ) {
	 			 rb1 = new RunningBean(release,totalDay,0,expectedOffDate,"2999-01-01",1,mb);
	 		
		    }else {
	 			//totalDay=mustDay
	 			 rb1 = new RunningBean(release,totalDay,0,expectedOffDate,"2999-01-01",0,mb);
	 		}
	 		
	 		mService.addrunning(rb1);
	 		
//	 		//取出來看看 ok
//	 		MovieBean mbget = mService.getMovieBeanById(1);
//	 		System.out.println("title:"+mbget.getTitle()+"合約:"+mbget.getContractDate()+"預估 :"+mbget.getExpectedProfit()
//            +"拆帳:"+mbget.getProfitRatio()+"狀態:"+mbget.getStatus()+"片長:"+mbget.getRunningTime()
//	);
//	 	

	 		//換URL
	 		RedirectView redirectView = new RedirectView();
	 		redirectView.setUrl(url+"/addmovie/suseece");
	 		//換URL
			return redirectView;
		}
		//一部電影的畫面
		@GetMapping(value = "/movie/show")//URL 跟<a href='movie/show'> 相關
		public String showMovie(Model model) {
			MovieBean mb = new MovieBean();
			
			//傳空的Bean去前端//如果controller有資料要
			model.addAttribute("Movie", mb);
		
			return "a/showMovie";//URL 跟 eclip 擺放位置相關
		}
		
		@GetMapping(value = "/AllMovie/show")//URL 跟<a href='movie/show'> 相關
		public String showAllMovie(Model model) {
		  LocalDate today = (LocalDate.now()).plusDays(1);
		  LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		  String dateTime = today.toString()+" "+time.toString();
		  
//		  try {
//			//找出來後runningBean直接是有帶Bean值得
//			  List<RunningBean> rb_list=mService.getAllOnMoive(today, today.plusDays(7));
//			  for(RunningBean rb :rb_list) {
//			      
//				  System.out.println(rb.getRunID());
//				  System.out.println(rb.getMovie().getTitle());
//			  }
//			  System.out.println("------------");
//		} catch (Exception e) {
//			  System.out.println("erro");
//		}
		 
			  List<RunningBean> rb_list=mService.getAllOnMoive(today);
			  System.out.println("size:"+rb_list.size());
               for(RunningBean rb :rb_list) {
			      
				  System.out.println("runID:"+rb.getRunID());
				  System.out.println(rb.getMovie().getTitle());
//				  mService.updateOffDate( rb , LocalDateTime.now());
				  System.out.println("======a");
				  HallBean a  = hService.getHall("A");
				  System.out.println("======b");
				  ShowTimeHistoryBean show =  new ShowTimeHistoryBean();
				  show.setHall(a);
				  show.setRun(rb);
				  show.setPalyStartTime(dateTime);
				  mService.addShowTimeHistory(show);
				 
				  
               }
              List <ShowTimeHistoryBean>sthb_list=mService.getShowTimeHistoryBean(rb_list);
          
            	  
        
		
		  
		 
		
       
			
			//傳空的Bean去前端//如果controller有資料要
//			model.addAttribute("Movie", rb_list);
		
			return "index-a";//URL 跟 eclip 擺放位置相關
		}


}
