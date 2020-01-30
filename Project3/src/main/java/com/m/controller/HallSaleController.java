package com.m.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.m.model.HallSaleBean;
import com.m.service.HallSaleService;

@Controller
public class HallSaleController {
	
	HallSaleService service;
	ServletContext context;
	
//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	@Autowired
	public void setService(HallSaleService service) {
		this.service = service;
	}
	
//	//到hs1
	@GetMapping(value = "/hall/sale")
	public String toHallSale() {
//		HallSaleBean hsb = new HallSaleBean();
//		model.addAttribute("hallSaleBean1", hsb);
		return "m/hallSale1";
	}
	
	//hallSale1資料傳輸
//	@PostMapping(value = "/hall/sale", produces = "application/vnd.ms-excel")
	@PostMapping(value = "/hall/sale")
	public @ResponseBody List<HallSaleBean> getHallSaleOrders(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("start")String sDate, 
			@RequestParam("end")String eDate) throws ServletException, IOException{
		List<HallSaleBean> hsbList = service.getHallSaleOutput(service.getHallSaleLists
				(service.getHallHrSubtotal(sDate,eDate)));
//		request.setAttribute("HallSaleBeanList", hsbList);
//		try {
//			request.getRequestDispatcher("m/hallSale1.jsp").forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		model.addAttribute("HallSaleBeanList", hsbList);
		System.out.println("hsbList=> " + hsbList.size() + "==="+ hsbList.get(0).getHallID());
//		response.reset();
//		request.setAttribute("hsbList", hsbList);
//        request.getRequestDispatcher("/WEB-INF/views/m/hallSale1.jsp").forward(request, response);
		return hsbList;
	}
	
//	//hallSale1資料傳輸
//	@PostMapping("/hall/sale")
//	public String getHallSaleOrders(Model model, HttpServletRequest request, HttpServletResponse response,
//			@RequestParam("start")String sDate, 
//			@RequestParam("end")String eDate){
//		List<HallSaleBean> hsbList = service.getHallSaleOutput(service.getHallSaleLists
//				(service.getHallHrSubtotal(sDate,eDate)));
////		request.setAttribute("HallSaleBeanList", hsbList);
////		try {
////			request.getRequestDispatcher("m/hallSale1.jsp").forward(request, response);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		model.addAttribute("HallSaleBeanList", hsbList);
//		System.out.println("hsbList=> " + hsbList.size() + "==="+ hsbList.get(0).getHallID());
//		
//		Gson gson = new Gson();
//		String jsonstring = gson.toJson(hsbList);
//		request.setAttribute("hsbList", hsbList);
//
//		return "m/hallSale1";
//	}
	
//	// URL為 /members, 搭配 GET方法可以傳回所有紀錄。
//	// produces屬性說明產生之資料的格式: produces = "application/vnd.ms-excel"
//	// 本方法可以Excel格式傳回所有Member紀錄
//	@RequestMapping(value = "/members", method = RequestMethod.GET, 
//			produces = "application/vnd.ms-excel")
//	public String queryAllHSExcel(Model model, HttpServletRequest request) {
//		List<HallSaleBean> hsbList = memberService.findAllMembers();
//		model.addAttribute("hsbList", hsbList);
//		return "m/hallSale1";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
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
