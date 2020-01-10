package com.l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.l.model.ProductsBean;
import com.l.service.ProductsService;


@Controller
public class ProductsController {
	ProductsService service;
	@Autowired
	public void setService(ProductsService service) {
		this.service = service;
	}
		
	//測試查詢多筆
	@RequestMapping("/products")
	public String getProducts(Model model) {
		List<ProductsBean> list=service.getProducts();
		model.addAttribute("products", list);
		return "products";
	}
	
	//測試查詢單筆
//		@RequestMapping(value = "/products", method = RequestMethod.GET)
//		public String getProducts(Model model) {
//			ProductsBean pb = new ProductsBean();
//			model.addAttribute("productsBean", pb);
//			return "products";
//		}
	
	//測試新增
		@RequestMapping(value = "/products/add", method = RequestMethod.GET)
		public String insertProduct(Model model) {
			ProductsBean pb = new ProductsBean();
			model.addAttribute("productsBean", pb);
			return "products";
		}
}
