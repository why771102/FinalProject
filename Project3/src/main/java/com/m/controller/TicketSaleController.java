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
import org.springframework.web.bind.annotation.PathVariable;
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
//		TicketSaleBean tsb = new TicketSaleBean();
//		model.addAttribute("TicketSaleBean1", tsb);
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
				tsebList = service.getTicketSaleInfo0(sDate, eDate);
				break;
			case "劇情":
				tsebList = service.getTicketSaleInfo1(sDate, eDate);
				break;
			case "喜劇":
				tsebList = service.getTicketSaleInfo2(sDate, eDate);
				break;
			case "愛情":
				tsebList = service.getTicketSaleInfo3(sDate, eDate);
				break;
			case "恐怖懸疑":
				tsebList = service.getTicketSaleInfo4(sDate, eDate);
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
	
	//ticketSale P2資料傳輸
	@GetMapping("/ticket/sale/{movieID}")
	public String getDates(Model model, @PathVariable Integer movieID) {
		//抓title
		String title = service.getMovieTitle(movieID);
		model.addAttribute("movieID", movieID);
		model.addAttribute("title", title);
		System.out.println("---to page 2---");
		return "m/ticketSale2";
	}
	
	@PostMapping("/ticket/sale/{movieID}")
	public @ResponseBody List<TicketSaleEarnBean> getDate(Model model, @PathVariable Integer movieID,
			@RequestParam("start") String sDate, @RequestParam("end") String eDate) {
		List<TicketSaleEarnBean> tsebListByDate = service.getTicketSaleInfoByDate(movieID, sDate, eDate);
		model.addAttribute("tsebListByDate",tsebListByDate); //jsp要接取資料
		System.out.println(tsebListByDate.size());
		System.out.println("---傳送tsebListByDate---");
		return tsebListByDate;
	}
	
	//ticketSale P3資料傳輸
	@GetMapping("/ticketSale/{movieID}/{date}")
	public String getDetail(Model model, @PathVariable Integer movieID,
			@PathVariable String date) {
		//抓title
		String title = service.getMovieTitle(movieID);
		model.addAttribute("movieID", movieID);
		model.addAttribute("date", date);
		model.addAttribute("title", title);
		System.out.println("---to page 3---");
		return "m/ticketSale3";
	}
	
	//ticketSale P3資料傳輸
	@PostMapping("/ticketSale/{movieID}/{date}")
	public @ResponseBody List<TicketSaleEarnBean> getDetail1(Model model, 
			@PathVariable Integer movieID, @PathVariable String date) {
		List<TicketSaleEarnBean> tsebListByDate = service.getWithinDate(date, movieID);
		model.addAttribute("tsebListByDate",tsebListByDate); //jsp要接取資料
		
		String title = service.getMovieTitle(movieID);
		model.addAttribute("title", title);
		
		System.out.println(tsebListByDate.size());
		System.out.println("$$$傳送tsebListByDate$$$");
		return tsebListByDate;
	}
}
