package com.m.controller;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.model.HallSaleBean;
import com.m.model.ProductSaleBean;
import com.m.model.ProductSaleEarnBean;
import com.m.service.ProductSaleService;

@Controller

public class ProductSaleController {

	ServletContext context;
	ProductSaleService service;

//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ProductSaleService service) {
		this.service = service;
	} 
	//================================== product/sale ===========================================
	
	// to ps1
	@GetMapping(value = "product/sale")
	public String toProductSale(Model model) {
		List<ProductSaleEarnBean> psebList = service.getAllPSEB();
		model.addAttribute("psebList", psebList);
		return "m/productSale1";
	}
	
	//show cate selection
	@ModelAttribute("cateSelection")
	public String addCateSelection(Model model) {
		String cateSelection = service.getCategoryNames();
		model.addAttribute("cateSelection", cateSelection);
		System.out.println(service.getFoodDates());
		return "m/productSale1";
	}
	
	//productSale P1資料傳輸
	@PostMapping(value = "product/sale")
	public @ResponseBody List<ProductSaleEarnBean> showProductInfo(Model model, HttpServletRequest request
			, @RequestParam(value = "cate", required=false) String cate
			, @RequestParam("start") String sDate, @RequestParam("end") String eDate) {
		System.out.println("start to get sth..");
		System.out.println("cate =>" + cate);
		System.out.println(sDate + "====" + eDate);
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		
		if (cate == null) {
			psebList = service.getAllProductInfo(sDate, eDate);
			System.out.println("this is default!");
		} else {
			System.out.println("start to get Info!!");
			switch (cate) {
			case "all":
				psebList = service.getAllProductInfo(sDate, eDate);
				break;
			case "allFood":
				psebList = service.getAllFoodInfo(sDate, eDate);
				break;
			case "套餐的餐點":
				psebList = service.getFoodInfo4(sDate, eDate);
				break;
			case "餐點":
				psebList = service.getFoodInfo5(sDate, eDate);
				break;
			case "周邊商品":
				psebList = service.getPeripheralInfo(sDate, eDate);
				break;
			default:
				psebList = service.getAllProductInfo(sDate, eDate);
				System.out.println("this is default..compare cate and related method");
				break;
		    }
		}
	
		System.out.println("---end1---");
		System.out.println("psebList=> " + psebList.size());
//		System.out.println("psebList=> " + psebList.size() + "==="+ psebList.get(0).getProductsBean().getProductName());
		return psebList;
	}
	
	@GetMapping("/product/sale/{productID}")
	public String getDates(Model model, @PathVariable Integer productID) {
		//抓productName
		String productName = service.getPname(productID);
		model.addAttribute("productID", productID);
		model.addAttribute("productName", productName);
		System.out.println("---to page 2---");
		return "m/productSale2";
	}
	
	@PostMapping("/product/sale/{productID}")
	public @ResponseBody List<ProductSaleEarnBean> getDate(Model model, @PathVariable Integer productID,@RequestParam("start") String sDate, @RequestParam("end") String eDate) {
		List<ProductSaleEarnBean> psebListByDate = service.getInfoByDate(productID, sDate, eDate);
		model.addAttribute("psebListByDate",psebListByDate); //jsp要接取資料
		System.out.println(psebListByDate.size());
		System.out.println("---傳送psebListByDate---");
		return psebListByDate; 
	}
	
	//excel
	@GetMapping(value = "product/sale/excel", produces ="application/vnd.ms-excel")
	public String queryAllpsebExcel(Model model, @RequestParam("exportExcel")String ps) {
		System.out.println("123321");
//		Gson gson = new Gson();
//		String ps1 = gson.toJson(ps);
//		System.out.println(ps1);
		Type listType = new TypeToken<ArrayList<ProductSaleEarnBean>>(){}.getType();
		List<ProductSaleEarnBean> psebList = new Gson().fromJson(ps, listType);
//		List<ProductSaleEarnBean> psebList = service.getAllPSEB();
		model.addAttribute("psebList", psebList);
		System.out.println("psebList==> " + psebList);
	      System.out.println("@@@@@ " + psebList.get(0).getPrice());
//		request.setAttribute("hsbList", hsbList);
	    return "product/sale/excel";
	}
}