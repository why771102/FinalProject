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
//		ProductSaleBean psb = new ProductSaleBean();
//		model.addAttribute("ProductSaleBean1", psb);
		return "m/productEarn1";
	}
	
	// to ps2
	@GetMapping(value = "product/earn/date")
	public String toProductSale2(Model model) {
//		ProductSaleBean psb = new ProductSaleBean();
//		model.addAttribute("ProductSaleBean2", psb);
		return "m/productEarn2";
	}
	
	//show cate selection
	@ModelAttribute("cateSelection")
	public String addCateSelection(Model model) {
		String cateSelection = service.getCategoryNames();
		model.addAttribute("cateSelection", cateSelection);
		System.out.println(service.getFoodDates());
		return "m/productEarn1";
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
		return psebList; //檢查這邊!!!
	}
	
	//productSale P2資料傳輸
	//抓取前一頁點選的產品名稱 
	//怎麼拿到呢???
	@RequestMapping(value = "product/earn")
	public String getProductName(@RequestParam("productName") String pName, HttpServletRequest request) { //productName
		System.out.println("看這邊~~~~~~~~~~~~~~~~~~~");
		System.out.println("pName=>" + pName);
		
		request.setAttribute("pName", pName);
		return "m/productEarn2"; //第一頁拿到之後要傳去第二頁
	}
	
//	@PostMapping(value= "product/sale/date")
//	public String getDates(Model model, @RequestParam("productName") String pName,@RequestParam("start") String sDate, @RequestParam("end") String eDate) {
//		List<LocalDate> datesList = service.showEachDate(sDate, eDate);
//		List<ProductSaleBean> psbListByDate= service.getByDateOutput(datesList, pName);
//		model.addAttribute("psbListByDate",psbListByDate); //jsp要接取資料
//		System.out.println("---傳送psbListByDate---");
//		return "m/productSale2"; //檢查這邊!!!
//	}
	
//	// to ps1
//	@GetMapping(value = "product/sale")
//	public String toProductSale(Model model) {
////		ProductSaleBean psb = new ProductSaleBean();
////		model.addAttribute("ProductSaleBean1", psb);
//		return "m/productSale1";
//	}
//	
//	// to ps2
//	@GetMapping(value = "product/sale/date")
//	public String toProductSale2(Model model) {
////		ProductSaleBean psb = new ProductSaleBean();
////		model.addAttribute("ProductSaleBean2", psb);
//		return "m/productSale2";
//	}
//	
//	//show cate selection
//	@ModelAttribute("cateSelection")
//	public String addCateSelection(Model model) {
//		String cateSelection = service.getCategoryNames();
//		model.addAttribute("cateSelection", cateSelection);
//		System.out.println(service.getFoodDates());
//		return "m/productSale1";
//	}
//	
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
//	
//	//productSale P1資料傳輸
//	@PostMapping(value = "product/sale")
//	public @ResponseBody HashMap<Integer, List<ProductSaleBean>> showProductInfo(Model model, @RequestParam(value = "cate", required=false) String cate
//			, @RequestParam("start") String sDate, @RequestParam("end") String eDate) {
//		System.out.println("start to get sth..");
//		System.out.println("cate =>" + cate);
//		System.out.println(sDate + "====" + eDate);
//		List<ProductSaleBean> psbList = new ArrayList<>();
//		HashMap<Integer, List<ProductSaleBean>> allFPmap = new HashMap<Integer, List<ProductSaleBean>>();
//		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
//		List<MOrderDetailBean> modbList = new ArrayList<>();
//		List<ProductsBean> pbList = new ArrayList<>();
//		List<SCOrdersBean> scodList = new ArrayList<>();
//		
//		if (cate == null) {
//			System.out.println("this is default..compare cate and related method");
//			//放入總食物
//			sthbList = service.getMovieDate(sDate, eDate);
//			modbList = service.getMODBList();
//			pbList = service.getAllFoodPB();
//			psbList = service.showFoodOutput(sthbList, modbList, pbList);
//			allFPmap.put(1, psbList); 
//			//放入周邊
//			pbList = service.getPeripheralPB();
//			scodList =  service.getPeripheralSCOrders(sDate, eDate);
//			psbList = service.getPeripheralOutput(pbList, scodList);
//			allFPmap.put(2, psbList);
//		} else {
//			System.out.println("start to get Info!!");
//			switch (cate) {
//			case "all":
//				//放入總食物
//				sthbList = service.getMovieDate(sDate, eDate);
//				modbList = service.getMODBList();
//				pbList = service.getAllFoodPB();
//				psbList = service.showFoodOutput(sthbList, modbList, pbList);
//				allFPmap.put(1, psbList); 
//				//放入周邊
//				pbList = service.getPeripheralPB();
//				scodList =  service.getPeripheralSCOrders(sDate, eDate);
//				psbList = service.getPeripheralOutput(pbList, scodList);
//				allFPmap.put(2, psbList);
//				break;
//			case "allFood":
//				sthbList = service.getMovieDate(sDate, eDate);
//				modbList = service.getMODBList();
//				pbList = service.getAllFoodPB();
//				psbList = service.showFoodOutput(sthbList, modbList, pbList);
//				allFPmap.put(1, psbList);
//				break;
//			case "套餐的餐點":
//				sthbList = service.getMovieDate(sDate, eDate);
//				modbList = service.getMODBList();
//				pbList = service.getFoodPB4();
//				psbList = service.showFoodOutput(sthbList, modbList, pbList);
//				allFPmap.put(1, psbList); 
//				break;
//			case "餐點":
//				sthbList = service.getMovieDate(sDate, eDate);
//				modbList = service.getMODBList();
//				pbList = service.getFoodPB5();
//				psbList = service.showFoodOutput(sthbList, modbList, pbList);
//				allFPmap.put(1, psbList); 
//				break;
//			case "周邊商品":
//				pbList = service.getPeripheralPB();
//				scodList =  service.getPeripheralSCOrders(sDate, eDate);
//				psbList = service.getPeripheralOutput(pbList, scodList);
//				allFPmap.put(1, psbList); 
//				break;
//			default:
//				//放入總食物
//				sthbList = service.getMovieDate(sDate, eDate);
//				modbList = service.getMODBList();
//				pbList = service.getAllFoodPB();
//				psbList = service.showFoodOutput(sthbList, modbList, pbList);
//				allFPmap.put(1, psbList); 
//				//放入周邊
//				pbList = service.getPeripheralPB();
//				scodList =  service.getPeripheralSCOrders(sDate, eDate);
//				psbList = service.getPeripheralOutput(pbList, scodList);
//				allFPmap.put(2, psbList);
//				System.out.println("this is default..compare cate and related method");
//				break;
//		    }
//		}
//		
//		//輸出List psbBean to p1
////		model.addAttribute("psbListOut", psbList);
//		model.addAttribute("allFPlistsOut", allFPmap);
//		System.out.println(psbList + "~~~~" +  allFPmap);
//		System.out.println("---end1---");
//		return allFPmap; //檢查這邊!!!
//	}
//	
//	//productSale P2資料傳輸
//	//抓取前一頁點選的產品名稱 
//	//怎麼拿到呢???
//	@PostMapping(value = "product/sale1")
//	public String getProductName(@RequestParam("productName") String pName) { //productName
//		System.out.println("pName=>" + pName);
//		return "m/productSale2"; //第一頁拿到之後要傳去第二頁
//	}
//	
//	@PostMapping(value= "product/sale/date")
//	public String getDates(Model model, @RequestParam("productName") String pName,@RequestParam("start") String sDate, @RequestParam("end") String eDate) {
//		List<LocalDate> datesList = service.showEachDate(sDate, eDate);
//		List<ProductSaleBean> psbListByDate= service.getByDateOutput(datesList, pName);
//		model.addAttribute("psbListByDate",psbListByDate); //jsp要接取資料
//		System.out.println("---傳送psbListByDate---");
//		return "m/productSale2"; //檢查這邊!!!
//	}
	
}