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
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return "m/hallSale1";
	}
	
	//hallSale1資料傳輸
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

	@ModelAttribute("HallSaleBean")
	public HallSaleBean generateMA() {
		HallSaleBean HB = new HallSaleBean();
		return HB;
	}
	
	//excel
	@GetMapping(value = "/hall/sale", produces = "application/vnd.ms-excel")
	public String queryAllHsbExcel(@ModelAttribute("HallSaleBean") HallSaleBean HB, 
			Model model, HttpServletRequest request,
			@RequestParam("start")String sDate, @RequestParam("end")String eDate) {
		List<HallSaleBean> hsbList = service.getHallSaleOutput(service.getHallSaleLists
				(service.getHallHrSubtotal(sDate,eDate)));
		model.addAttribute("hsbList", hsbList);
//		request.setAttribute("hsbList", hsbList);
		return "m/hallSale1";
	}
	
}
