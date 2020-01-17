package com.m.controller;

import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "/hall/sale")
	public String outputHsb(Model model) {
		HallSaleBean hsb = new HallSaleBean();
		model.addAttribute("hallSaleBean", hsb);
		return "m/hallSale1";
	}
	
	//hallSale1資料傳輸
	@PostMapping(value = "/hall/sale")
	public String getHallSaleOrders(Model model,
			@RequestParam("sDate")String sDate, 
			@RequestParam("sDate")String eDate){
		List<HallSaleBean> hsbList = service.getHallSaleOutput(service.getHallSaleLists
				(service.getHallHrSubtotal(sDate,eDate)));
		model.addAttribute("HallSaleBeanList", hsbList);
		return "m/hallSale1";
	}
}
