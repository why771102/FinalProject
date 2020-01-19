package com.m.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m.model.HallSaleBean;
import com.m.service.HallSaleService;

@Controller
public class HallSaleController {
	
	HallSaleService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	public void setService(HallSaleService service) {
		this.service = service;
	}
	
	//到hs1
	@GetMapping(value = "/hall/sale")
	public String toHallSale() {
//		HallSaleBean hsb = new HallSaleBean();
//		model.addAttribute("hallSaleBean1", hsb);
		return "m/hallSale1";
	}
	
	//hallSale1資料傳輸
	@PostMapping("/hall/sale")
	public @ResponseBody List<HallSaleBean> getHallSaleOrders(Model model,
			@RequestParam("start")String sDate, 
			@RequestParam("end")String eDate){
		List<HallSaleBean> hsbList = service.getHallSaleOutput(service.getHallSaleLists
				(service.getHallHrSubtotal(sDate,eDate)));
//		model.addAttribute("HallSaleBeanList", hsbList);
		return hsbList;
	}
	
	
//	//到hs2
//	@GetMapping(value = "/hall/sale/date")
//	public String toHallSaleDate(Model model) {
//		HallSaleBean hsb = new HallSaleBean();
//		model.addAttribute("hallSaleBean2", hsb);
//		return "m/hallSale2";
//	}
//	
//	//hallSale2資料傳輸
//	@PostMapping(value = "/date")
//	public String getHallSaleOrders1(Model model,
//			@RequestParam("sDate")String sDate, 
//			@RequestParam("eDate")String eDate){
//		List<HallSaleBean> hsbList = service.getHallSaleOutput(service.getHallSaleLists
//				(service.getHallHrSubtotal(sDate,eDate)));
//		model.addAttribute("HallSaleBeanList", hsbList);
//		return "m/hallSale2";
//	}
	
}
