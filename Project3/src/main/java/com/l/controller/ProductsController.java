package com.l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	//測試查詢類別們
		@RequestMapping("/queryCategories")
		public String queryCategories(Model model) {
			List<String> list=service.getCategories();
			model.addAttribute("categoryList", list);
			return "category";
		}
		//測試查詢類別用ID
			@RequestMapping("/products/{category}")
				public String queryCategory(@PathVariable("category")Integer category,Model model) {
					List<ProductsBean> products=service.getCategory(category);
					model.addAttribute("products", products);
					return "products";
				}
	
	
	//測試查詢多筆
		@RequestMapping("/update/products")
		public String updateProducts(Model model) {
			service.updateProducts();
			return "redirect:/products";
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
