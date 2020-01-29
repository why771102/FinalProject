package com.m.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m.model.HallSaleBean;
import com.m.model.ProductSaleEarnBean;
import com.m.model.TicketSaleBean;
import com.m.model.TicketSaleEarnBean;
import com.m.service.TicketSaleService;

@Controller
public class TicketSaleController {
	
	ServletContext context;
	TicketSaleService service;
	
//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	public void setService(TicketSaleService service) {
		this.service = service;
	}
	
	//to ts page1
	@GetMapping(value= "/ticket/sale")
	public String toTicketSale(Model model) {
		TicketSaleBean tsb = new TicketSaleBean();
		model.addAttribute("TicketSaleBean1", tsb);
		return "m/ticketSale1";
	}
	
	//新增genre下拉式選單
	@ModelAttribute("genreSelection")
	public String addSelection(Model model) {
		String genreSelection = service.getGenre();
		model.addAttribute("genreSelection", genreSelection);
		return "m/ticketSale1";
	}
	
	@PostMapping(value = "ticket/sale")
	public @ResponseBody List<TicketSaleEarnBean> showTicketInfo(Model model, HttpServletRequest request
			, @RequestParam(value = "genre", required=false) String genre
			, @RequestParam("start") String sDate, @RequestParam("end") String eDate) {
		System.out.println("start to get sth..");
		System.out.println("genre =>" + genre);
		System.out.println(sDate + "====" + eDate);
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		
		if (genre == null) {
			tsebList = service.getTicketSaleInfo(sDate, eDate);
			System.out.println("this is default!");
		} else {
			System.out.println("start to get Info!!");
			switch (genre) {
			case "all":
				tsebList = service.getTicketSaleInfo(sDate, eDate);
				break;
			case "其他": //0(其他)1(劇情)2(喜劇)3(愛情)4(恐怖懸疑)
//				tsebList = service.getAllFoodInfo(sDate, eDate);
				break;
			case "劇情":
//				tsebList = service.getFoodInfo4(sDate, eDate);
				break;
			case "喜劇":
//				tsebList = service.getFoodInfo5(sDate, eDate);
				break;
			case "愛情":
//				tsebList = service.getPeripheralInfo(sDate, eDate);
				break;
			case "恐怖懸疑":
//				tsebList = service.getPeripheralInfo(sDate, eDate);
				break;
			default:
				tsebList = service.getTicketSaleInfo(sDate, eDate);
				System.out.println("this is default..compare cate and related method");
				break;
		    }
		}
	
		System.out.println("---end1---");
		System.out.println("tsebList=> " + tsebList.size());
//		System.out.println("psebList=> " + psebList.size() + "==="+ psebList.get(0).getProductsBean().getProductName());
		return tsebList; //檢查這邊!!!
	}
}
