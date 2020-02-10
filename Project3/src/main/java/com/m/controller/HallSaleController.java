package com.m.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
import com.google.gson.reflect.TypeToken;
import com.m.model.HallSaleBean;
import com.m.model.ProductSaleEarnBean;
import com.m.service.HallSaleService;

@Controller
public class HallSaleController {
	
	HallSaleService service;
//	ServletContext context;
	
//	@Autowired
//	public void setContext(ServletContext context) {
//		this.context = context;
//	}
	
	@Autowired
	public void setService(HallSaleService service) {
		this.service = service;
	}
	
	//到hs1
	@GetMapping(value = "/hall/sale")
	public String toHallSale() {
		return "m/hallSale";
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
	
	//pdf
	@PostMapping(value = "/hall/sale/hallSale", produces = "application/pdf")
	public String queryAllHsbPdf(@RequestParam("exportPdf")String ps, 
			Model model, HttpServletRequest request) {
		System.out.println("abcdefg");
		Type listType = new TypeToken<ArrayList<HallSaleBean>>(){}.getType();
		List<HallSaleBean> hsbList = new Gson().fromJson(ps, listType);
		
		model.addAttribute("hsbList", hsbList);
		System.out.println("test~~~~~~~~~" +  hsbList);
//		request.setAttribute("hsbList", hsbList);
		return "hall/sale/hallSale";
	}
	
//	@PostMapping(value = "/product/sale/productSale", produces ="application/vnd.ms-excel")
//	public String queryAllpsebExcel(Model model, @RequestParam("exportExcel")String ps) {
//		Type listType = new TypeToken<ArrayList<ProductSaleEarnBean>>(){}.getType();
//		List<ProductSaleEarnBean> psebList = new Gson().fromJson(ps, listType);
//		model.addAttribute("psebList", psebList);
//		System.out.println("psebList==> " + psebList);
//	    return "product/sale/productSale";
//	}
}
