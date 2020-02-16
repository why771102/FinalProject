package com.l.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a.model.ShowTimeHistoryBean;
import com.l.model.ProductsBean;
import com.l.service.ProductsService;
import com.l.service.mOrdersService;

@Controller
public class testProductsController {
	// 普通票ID
	public final Integer productNormal = 1;
	// 銀行票ID
	public final Integer productBank = 3;
	// 個人套票ID
	public final Integer productdiscount = 13;
	// 雙人套票ID
	public final Integer productdiscount2 = 15;
	// 熟食頭ID
	public final Integer productfood = 7;
	// 熟食尾ID
	public final Integer productfood2 = 9;
	// 可樂頭ID
	public final Integer productCoke = 4;
	// 可樂尾ID
	public final Integer productCoke2 = 6;
	// 爆米花頭ID
	public final Integer productPopcorn = 10;
	// 爆米花尾ID
	public final Integer productPopcorn2 = 12;

	ProductsService service;
	mOrdersService service2;

	@Autowired
	public void setService(ProductsService service, mOrdersService service2) {
		this.service = service;
		this.service2 = service2;
	}

	// 顯示4種類別資料
	@RequestMapping("/testProducts")
	public String showAllProducts(Model model) {
		// 票
		List<ProductsBean> mapticket = new ArrayList<>();
		List<ProductsBean> mapdiscountTicket = new ArrayList<>();
		// 熱食
		List<ProductsBean> mapfood = new ArrayList<>();
		// 飲料
		List<ProductsBean> mapdrink = new ArrayList<>();
		// 爆米花
		List<ProductsBean> mappopcorn = new ArrayList<>();
		// map加入套票
		mapdiscountTicket.add(service.getProduct(productdiscount));
		// map加入套票2
		mapdiscountTicket.add(service.getProduct(productdiscount2));
		// map加入銀行票
		mapticket.add(service.getProduct(productBank));
		// map加入普通票
		mapticket.add(service.getProduct(productNormal));
		// map加入熟食
		mapticket.get(0);

		for (int ini = productfood; ini <= productfood2; ini++) {
			mapfood.add(service.getProduct(ini));
		}
		// map加入飲料
		for (int ini = productCoke; ini <= productCoke2; ini++) {
			mapdrink.add(service.getProduct(ini));
		}
		// map加入爆米花
		for (int ini = productPopcorn; ini <= productPopcorn2; ini++) {
			mappopcorn.add(service.getProduct(ini));
		}
		model.addAttribute("ticket", mapticket);
		model.addAttribute("disountTicket", mapdiscountTicket);
		model.addAttribute("food", mapfood);
		model.addAttribute("drink", mapdrink);
		model.addAttribute("popcorn", mappopcorn);

		return "l/testBookNormal";
	}

	@RequestMapping("/testOrderConfirm")
	public String orderConfirm(Model model, HttpServletRequest request, HttpServletResponse response) {
		// 票
		List<ProductsBean> mapticket = new ArrayList<>();
		List<ProductsBean> mapdiscountTicket = new ArrayList<>();
		// 熱食
		List<ProductsBean> mapfood = new ArrayList<>();
		// 飲料
		List<ProductsBean> mapdrink = new ArrayList<>();
		// 爆米花
		List<ProductsBean> mappopcorn = new ArrayList<>();
		// map加入套票
		mapdiscountTicket.add(service.getProduct(productdiscount));
		// map加入套票2
		mapdiscountTicket.add(service.getProduct(productdiscount2));
		// map加入銀行票
		mapticket.add(service.getProduct(productBank));
		// map加入普通票
		mapticket.add(service.getProduct(productNormal));
		// map加入熟食
		mapticket.get(0);

		for (int ini = productfood; ini <= productfood2; ini++) {
			mapfood.add(service.getProduct(ini));
		}
		// map加入飲料
		for (int ini = productCoke; ini <= productCoke2; ini++) {
			mapdrink.add(service.getProduct(ini));
		}
		// map加入爆米花
		for (int ini = productPopcorn; ini <= productPopcorn2; ini++) {
			mappopcorn.add(service.getProduct(ini));
		}
		model.addAttribute("ticket", mapticket);
		model.addAttribute("disountTicket", mapdiscountTicket);
		model.addAttribute("food", mapfood);
		model.addAttribute("drink", mapdrink);
		model.addAttribute("popcorn", mappopcorn);
		return "l/testOrderconfirm";
	}

}
