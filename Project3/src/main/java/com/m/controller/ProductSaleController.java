package com.m.controller;

import java.time.LocalDate;
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
	
	// to ps2
	@GetMapping(value = "product/sale/date")
	public String toProductSale2(Model model) {
		ProductSaleBean psb = new ProductSaleBean();
		model.addAttribute("ProductSaleBean2", psb);
		return "m/productSale2";
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
	
	//productSale P1資料傳輸
	@PostMapping(value = "product/sale")
	public String showProductInfo(Model model, @RequestParam(value = "cate", required=false) String cate
			, @RequestParam("start") String sDate, @RequestParam("end") String eDate) {
		System.out.println("start to get sth..");
		System.out.println("cate =>" + cate);
		System.out.println(sDate + "====" + eDate);
		List<ProductSaleBean> psbList = new ArrayList<>();
		HashMap<Integer, List<ProductSaleBean>> allFPlists = new HashMap<Integer, List<ProductSaleBean>>();
		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
		List<MOrderDetailBean> modbList = new ArrayList<>();
		List<ProductsBean> pbList = new ArrayList<>();
		List<SCOrdersBean> scodList = new ArrayList<>();
		
		if (cate == null) {
			System.out.println("this is default..compare cate and related method");
			//放入總食物
			sthbList = service.getMovieDate(sDate, eDate);
			modbList = service.getMODBList();
			pbList = service.getAllFoodPB();
			psbList = service.showFoodOutput(sthbList, modbList, pbList);
			allFPlists.put(1, psbList); 
			//放入周邊
			pbList = service.getPeripheralPB();
			scodList =  service.getPeripheralSCOrders(sDate, eDate);
			psbList = service.getPeripheralOutput(pbList, scodList);
			allFPlists.put(2, psbList);
		} else {
			System.out.println("start to get Info!!");
			switch (cate) {
			case "all":
				//放入總食物
				sthbList = service.getMovieDate(sDate, eDate);
				modbList = service.getMODBList();
				pbList = service.getAllFoodPB();
				psbList = service.showFoodOutput(sthbList, modbList, pbList);
				allFPlists.put(1, psbList); 
				//放入周邊
				pbList = service.getPeripheralPB();
				scodList =  service.getPeripheralSCOrders(sDate, eDate);
				psbList = service.getPeripheralOutput(pbList, scodList);
				allFPlists.put(2, psbList);
				break;
			case "allFood":
				sthbList = service.getMovieDate(sDate, eDate);
				modbList = service.getMODBList();
				pbList = service.getAllFoodPB();
				psbList = service.showFoodOutput(sthbList, modbList, pbList);
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
				scodList =  service.getPeripheralSCOrders(sDate, eDate);
				psbList = service.getPeripheralOutput(pbList, scodList);
				break;
			default:
				//放入總食物
				sthbList = service.getMovieDate(sDate, eDate);
				modbList = service.getMODBList();
				pbList = service.getAllFoodPB();
				psbList = service.showFoodOutput(sthbList, modbList, pbList);
				allFPlists.put(1, psbList); 
				//放入周邊
				pbList = service.getPeripheralPB();
				scodList =  service.getPeripheralSCOrders(sDate, eDate);
				psbList = service.getPeripheralOutput(pbList, scodList);
				allFPlists.put(2, psbList);
				System.out.println("this is default..compare cate and related method");
				break;
		    }
		}
		//輸出List psbBean to p1
		model.addAttribute("psbListOut", psbList);
		model.addAttribute("allFPlistsOut", allFPlists);
		System.out.println(psbList + "~~~~" +  allFPlists);
		System.out.println("---end1---");
		return "m/productSale1"; //檢查這邊!!!
	}
	
	//productSale P2資料傳輸
	//抓取前一頁點選的產品名稱 
	//怎麼拿到呢???
	@GetMapping
	public String getProductName(Model model, @RequestParam("productName") String pName) { //productName
		System.out.println("pName=>" + pName);
		return pName; //第一頁拿到之後要傳去第二頁
	}
	
	@PostMapping(value= "product/sale/date")
	public String getDates(Model model, @RequestParam("productName") String pName,@RequestParam("start") String sDate, @RequestParam("end") String eDate) {
		List<LocalDate> datesList = service.showEachDate(sDate, eDate);
		List<ProductSaleBean> psbListByDate= service.getByDateOutput(datesList, pName);
		model.addAttribute("psbListByDate",psbListByDate); //jsp要接取資料
		System.out.println("---傳送psbListByDate---");
		return "m/productSale2"; //檢查這邊!!!
	}
	
}