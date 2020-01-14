package com.l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.l.model.MOrderBean;
import com.l.model.ProductsBean;
import com.l.service.ProductsService;


@Controller
public class mOrderController {
	ProductsService service;
	@Autowired
	public void setService(ProductsService service) {
		this.service = service;
	}
		
//	//測試查詢多筆
//	@RequestMapping("/bookticket")
//	public String getProducts(Model model) {
//		List<MOrderBean> list=service.getProducts();
//		model.addAttribute("Products", list);
//		return "l/bookticket";
//	}
//	//測試查詢類別們
//		@RequestMapping("/queryCategories")
//		public String queryCategories(Model model) {
//			List<String> list=service.getCategories();
//			model.addAttribute("CategoryList", list);
//			return "l/category";
//		}
//		//測試查詢類別用ID 
//			@RequestMapping("/products/{category}")
//				public String queryCategory(@PathVariable("category")Integer category,Model model) {
//					List<ProductsBean> products=service.getCategory(category);
//					model.addAttribute("Products", products);
//					return "l/products";
//				}
//	
//			//測試查詢單筆
//			@RequestMapping("/product")
//			public String getProduct(@RequestParam("id")Integer productID,Model model) {
//				model.addAttribute("Product",service.getProduct(productID));
//				return "l/product";
//			}
//			
//	//測試新增方法*2       
//		@RequestMapping(value = "/products/add", method = RequestMethod.GET)
//		public String getinsertProduct(Model model) {
//			ProductsBean pb = new ProductsBean();
//			model.addAttribute("ProductsBean", pb);
//			return "l/insertproducts";
//	}
//		@RequestMapping(value = "/products/add", method = RequestMethod.POST)
//		public String proccessinsertProduct(@ModelAttribute("ProductsBean") ProductsBean pb) {
//			service.insertProduct(pb);
//			return "redirect:/products";
//		}
}
