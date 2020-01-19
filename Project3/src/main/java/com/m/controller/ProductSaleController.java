package com.m.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.model.ProductSaleBean;
import com.m.service.ProductSaleService;

@Controller
public class ProductSaleController {

	ServletContext context;
	ProductSaleService service;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ProductSaleService service) {
		this.service = service;
	}

	// to ps1
	@GetMapping(value = "product/sale")
	public String toProductSale(Model model) {
		ProductSaleBean psb = new ProductSaleBean();
		model.addAttribute("ProductSaleBean1", psb);
		return "m/productSale1";
	}
	
	//show cate selection
	@ModelAttribute("cateSelection")
	public String addCateSelection(Model model) {
		String cateSelection = service.getCategoryNames();
		model.addAttribute("cateSelection", cateSelection);
		return "m/productSale1";
	}
	
//	@PostMapping(value = "product/sale")
//	public String showDefaultInfo(Model model, @RequestParam("start") String sDate, 
//			@RequestParam("end") String eDate) {
//		List<ProductSaleBean> psbList = new ArrayList<>();
//		HashMap<Integer, List<ProductSaleBean>> allFPlists = 
//				new HashMap<Integer, List<ProductSaleBean>>();
//		psbList = service.getProductSaleOutput(service.showFoodOrders(sDate, eDate));
//		allFPlists.put(1, psbList);
//		psbList = service.getProductSaleOutput(service.showPeripheralOrders(sDate, eDate));
//		allFPlists.put(2, psbList);
//		
//		model.addAttribute("allFPlists", allFPlists);
//		return "m/productSale1";
//	}
	
	@PostMapping(value = "product/sale")
	public List<ProductSaleBean> showProductInfo(Model model, @RequestParam("cate") String cate
			, @RequestParam("start") String sDate, @RequestParam("end") String eDate) {
		
		List<ProductSaleBean> psbList = new ArrayList<>();
		HashMap<Integer, List<ProductSaleBean>> allFPlists = new HashMap<Integer, List<ProductSaleBean>>();
		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
		List<MOrderDetailBean> modbList = new ArrayList<>();
		List<ProductsBean> pbList = new ArrayList<>();
		switch (cate) {
		case "all":
//			psbList = service.getProductSaleOutput(service.showFoodOrders(sDate, eDate));
//			allFPlists.put(1, psbList);
//			psbList = service.getProductSaleOutput(service.showPeripheralOrders(sDate, eDate));
//			allFPlists.put(2, psbList);
			break;
		case "allFood":
//			psbList = service.getProductSaleOutput(service.showFoodOrders(sDate, eDate));
			break;
		case "套餐的餐點":
			sthbList = service.getMovieDate(sDate, eDate);
			modbList = service.getMODBList();
			pbList = service.getFoodPB4();
			psbList = service.showFoodOutput(sthbList, modbList, pbList);
			break;
		case "餐點":
			sthbList = service.getMovieDate(sDate, eDate);
			modbList = service.getMODBList();
			pbList = service.getFoodPB5();
			psbList = service.showFoodOutput(sthbList, modbList, pbList);
			break;
		case "周邊商品":
			pbList = service.getPeripheralPB();
			List<SCOrdersBean> scodList =  service.getPeripheralSCOrders(sDate, eDate);
			psbList = service.getPeripheralOutput(pbList, scodList);
			break;
		default:
			System.out.println("compare cate and related method..");

		}
		//輸出List psbBean to p1
		model.addAttribute("psbListOut", psbList);
		return psbList;
	}
}