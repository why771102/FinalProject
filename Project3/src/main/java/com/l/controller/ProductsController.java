package com.l.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.l.model.ProductsBean;


@Controller
public class ProductsController {
	//測試查詢
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getProducts(Model model) {
		ProductsBean pb = new ProductsBean();
		model.addAttribute("productsBean", pb);
		return "products";
	}
	
}
