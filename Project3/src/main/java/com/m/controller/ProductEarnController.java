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

import com.m.model.ProductSaleEarnBean;
import com.m.service.ProductEarnService;

@Controller

public class ProductEarnController {

	ServletContext context;
	ProductEarnService service;

//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ProductEarnService service) {
		this.service = service;
	} 
	//================================== product/earn ===========================================
	
	// to ps1
	@GetMapping(value = "product/earn")
	public String toProductSale(Model model) {
		return "m/productEarn1";
	}
	
	//show cate selection
	@ModelAttribute("cateSelection")
	public String addCateSelection(Model model) {
		String cateSelection = service.getCategoryNames();
		model.addAttribute("cateSelection", cateSelection);
//		System.out.println(service.getFoodDates());
		return "m/productEarn1";
	}

	//productSale P1資料傳輸
	@PostMapping(value = "product/earn")
	public @ResponseBody List<ProductSaleEarnBean> showProductInfo(Model model, HttpServletRequest request
			, @RequestParam(value = "cate", required=false) String cate
			, @RequestParam("start") String sDate, @RequestParam("end") String eDate) {
		System.out.println("start to get sth..");
		System.out.println("cate =>" + cate);
		System.out.println(sDate + "====" + eDate);
		List<ProductSaleEarnBean> psebList = new ArrayList<>();
		
		if (cate == null) {
			psebList = service.getAllProductInfo(sDate, eDate);
//			System.out.println("this is default!");
		} else {
//			System.out.println("start to get Info!!");
			switch (cate) {
			case "全部商品":
				psebList = service.getAllProductInfo(sDate, eDate);
				break;
			case "餐點總覽":
				psebList = service.getAllFoodInfo(sDate, eDate);
				break;
			case "套餐的餐點":
				psebList = service.getFoodInfo4(sDate, eDate);
				break;
			case "餐點":
				psebList = service.getFoodInfo5(sDate, eDate);
				break;
			case "公仔":
				psebList = service.getPeripheralInfo6(sDate, eDate);
				break;
			case "衣服":
				psebList = service.getPeripheralInfo7(sDate, eDate);
				break;
			case "爆米花桶":
				psebList = service.getPeripheralInfo8(sDate, eDate);
				break;
			case "杯子餐具":
				psebList = service.getPeripheralInfo9(sDate, eDate);
				break;
			case "娃娃":
				psebList = service.getPeripheralInfo10(sDate, eDate);
				break;
			case "電影海報":
				psebList = service.getPeripheralInfo11(sDate, eDate);
				break;
			case "電子產品":
				psebList = service.getPeripheralInfo12(sDate, eDate);
				break;
			case "其他":
				psebList = service.getPeripheralInfo13(sDate, eDate);
				break;
			default:
				psebList = service.getAllProductInfo(sDate, eDate);
//				System.out.println("this is default..compare cate and related method");
				break;
		    }
		}
		System.out.println("---end1---");
		System.out.println("psebList=> " + psebList.size());
//		System.out.println("psebList=> " + psebList.size() + "==="+ psebList.get(0).getProductsBean().getProductName());
		return psebList;
	}
	
	//productSale P2資料傳輸
	@GetMapping("/product/earn/{productID}")
	public String getDates(Model model, @PathVariable Integer productID) {
		//抓productName
		String productName = service.getPname(productID);
		model.addAttribute("productID", productID);
		model.addAttribute("productName", productName);
		System.out.println("---to page 2---");
		return "m/productEarn2";
	}
	
	@PostMapping("/product/earn/{productID}")
	public @ResponseBody List<ProductSaleEarnBean> getDate(Model model, @PathVariable Integer productID,@RequestParam("start") String sDate, @RequestParam("end") String eDate) {
		List<ProductSaleEarnBean> psebListByDate = service.getInfoByDate(productID, sDate, eDate);
		model.addAttribute("psebListByDate",psebListByDate); //jsp要接取資料
		System.out.println(psebListByDate.size());
		System.out.println("---傳送psebListByDate---");
		return psebListByDate;
	}
}