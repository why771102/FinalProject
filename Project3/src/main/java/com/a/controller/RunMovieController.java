package com.a.controller;

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
import com.a.service.MovieService;
import com.c.model.HallBean;
import com.c.service.HallService;

@Controller
public class RunMovieController {
	ServletContext context;
	MovieService mService;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(MovieService mService) {
		this.mService = mService;
	}
	
	//新增電影方法
	
		@GetMapping(value = "/movie/add")//URL
		public String proceessAdd(Model model) {
			MovieBean mb = new MovieBean();
			RunningBean rb = new RunningBean();
			//傳空的Bean去前端//如果controller有資料要
			model.addAttribute("Movie", mb);
			model.addAttribute("Run", rb);
			return "a/addMovie";
		}
		
		@PostMapping(value = "/movie/add")
		public RedirectView addNewMove(Model model, @ModelAttribute("Movie") MovieBean mb, BindingResult result, HttpServletRequest request) {
			String url = request.getContextPath();
			System.out.println(url);
			String[] suppressedFields = result.getSuppressedFields();
			
			if(suppressedFields.length > 0) {
				throw new RuntimeException("傳入不允許的欄位");
			} 
			mb.setStatus(0);
			System.out.println("title:"+mb.getTitle()+"合約:"+mb.getContractDate()+"預估 :"+mb.getExpectedProfit()
			                   +"拆帳:"+mb.getProfitRatio()+"狀態:"+mb.getStatus()+"片長:"+mb.getRunningTime()
					);
			System.out.println("導演:"+mb.getDirector()+"演員:"+mb.getCast()+"預告"+mb.getTrailer()
			                    +"類型"+mb.getGenre()+"分級:"+mb.getMovieRating()+"內容:"+mb.getPlotSummary()
					);
			
	 		mService.addmovie(mb);
//	 		rb.setMovie(mb);
//	 		rb.setOffDate("2999-01-01 00:00:00" );
//	 		rb.setOnDate(0);
//	        int day = Integer.parseInt(MustShowDay);
//	 		mService.addrunning(rb);
	 		
//	 		model.addAttribute("hallID", hb.getHallID());
	 		//換URL
	 		RedirectView redirectView = new RedirectView();
	 		redirectView.setUrl(url+"/run/addrun");
	 		//換URL
			return redirectView;
		}

}
