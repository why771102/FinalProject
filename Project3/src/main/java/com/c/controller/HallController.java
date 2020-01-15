package com.c.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.c.model.HallBean;
import com.c.model.SeatsBean;
import com.c.service.HallService;
import com.c.service.SeatsService;

@Controller
public class HallController {
	
	HallService hservice;
	SeatsService sservice;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(HallService hservice, SeatsService sservice) {
		this.hservice = hservice;
		this.sservice = sservice;
	}
	
	//新增廳方法
	@GetMapping(value = "/hall/add")
	public String addNewHall(Model model) {
		HallBean hb = new HallBean();
		model.addAttribute("hallBean", hb);
		return "c/addHall";
	}
	
	@PostMapping(value = "/hall/add")
	public RedirectView processAddNewHall(Model model, @ModelAttribute("hallBean") HallBean hb, BindingResult result, HttpServletRequest request) {
		String url = request.getContextPath();
		System.out.println(url);
		String[] suppressedFields = result.getSuppressedFields();
		
		if(suppressedFields.length > 0) {
			throw new RuntimeException("傳入不允許的欄位");
		} 
 		hservice.insertHall(hb);
 		
 		model.addAttribute("hallID", hb.getHallID());
 		
 		RedirectView redirectView = new RedirectView();
 		redirectView.setUrl(url+"/seats/addSeats");
		return redirectView;
	}
	
	
	@PostMapping(value = "/hall/updateHallStatus")
	public String deleteHall(@RequestParam("hallID") String hallID) {
		HallBean hb = hservice.getHall(hallID);
		hservice.updateHall(hb);
		String flag = "hall";
		List<SeatsBean> listSB = sservice.getAllSeatsUsingHallID(hallID);
		for(int seat = 0; seat < listSB.size(); seat++) {
			sservice.updateSeatStatus(1, listSB.get(seat).getSeatID(), flag);
		}
		return "/index-c";
	}
	
//	@InitBinder
//	public void whiteListing(WebDataBinder binder) {
//		binder.setAllowedFields("empName", "roleId", "email", "password", "status", "startDate" ,"endDate");
//	}
//	
	//----------------------------------
	
	@RequestMapping(value = "/halls")
	public String getAllHalls(Model model) {
		List<HallBean> allHalls = hservice.getAllHalls(0);
		model.addAttribute("allHalls", allHalls);
		return "halls";
	}
	
	
	
	
	

}
