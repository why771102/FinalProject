//package com.m.controller;
//
//import java.util.List;
//
//import javax.servlet.ServletContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.c.model.HallBean;
//import com.m.model.HallSaleBean;
//import com.m.service.HallSaleService;
//
//@Controller
//public class HallSaleController {
//	
//	HallSaleService service;
//	ServletContext context;
//	
//	@Autowired
//	public void setContext(ServletContext context) {
//		this.context = context;
//	}
//	
//	@Autowired
//	public void setService(HallSaleService service) {
//		this.service = service;
//	}
//	
//	@RequestMapping(value = "/hallSale")
//	public String getHallSaleOrders(Model model, String sDate, String eDate){
//		List<HallSaleBean> hsbList = service.getHSBOutput(service.getHallHrSubtotal(sDate, eDate));
//		model.addAttribute("HallSaleBeanList", hsbList);
//		return "hallSale";
//	}
//}
