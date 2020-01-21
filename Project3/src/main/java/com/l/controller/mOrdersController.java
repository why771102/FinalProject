package com.l.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	//查詢排片ID之所有電影ID	
	@RequestMapping("/morders")
	public String getRunbyID(Model model) {
		List<RunningBean> list=service.getRunbyID();
		model.addAttribute("Movies", list);
		return "l/morders";
	}
	
	//查詢所有場次ID	
	@RequestMapping("/queryShowTimeID")
	public String getShowTimebyID(Model model) {
		List<String> list=service.getAllShowTimeID();
		model.addAttribute("AllShowTimeID", list);
		return "l/morders";
	}
	
	//用runID查詢播放日期時間
	@RequestMapping("/morders/{runID}")
	public String getShowTimebyID(@PathVariable("runID")Integer runID,Model model) {
			List<ShowTimeHistoryBean> showtime=service.getShowTimebyID(runID);
			model.addAttribute("showtime", showtime);
			return "l/morders2";
		}
	
	
	
	
//	@ModelAttribute("mtitle")
//	public @ResponseBody String getmtitle(){
//		
//		List<MovieBean> list = service.getMovieName();
//		Gson gson = new Gson();
//		List<Map<String,String>> listmap = new ArrayList<>();
//		for(MovieBean mb:list) {
//			Map<String,String> mtitleMap=new HashMap<>();
//			mtitleMap.put("movieID",mb.getMovieID().toString());
//			mtitleMap.put("title",mb.getTitle());
//			listmap.add(mtitleMap);
//		}
//		String mapJson = gson.toJson(listmap);
//		
//		
//		System.out.println(mapJson);
//		return mapJson;	
//	}
	
	
	
}
