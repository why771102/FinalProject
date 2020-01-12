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
	
			//測試查詢單筆
			@RequestMapping("/product")
			public String getProduct(@RequestParam("id")Integer productID,Model model) {
				model.addAttribute("product",service.getProduct(productID));
				return "product";
			}
			
	//測試更新*2
		@RequestMapping(value = "/update/products", method = RequestMethod.GET)
		public String getupdateProducts(Model model) {
			ProductsBean pb=new ProductsBean();
			model.addAttribute("ProductsBean", pb);
			return "updateproducts";
		}
	
		@RequestMapping(value = "/update/products", method = RequestMethod.POST)
		public String proccessupdateProducts(@ModelAttribute("ProductsBean") ProductsBean pb) {
			service.insertProduct(pb);
			return "redirect:/products";
		}
	
		
		
	//測試新增方法*2       
		@RequestMapping(value = "/products/add", method = RequestMethod.GET)
		public String getinsertProduct(Model model) {
			ProductsBean pb = new ProductsBean();
			model.addAttribute("ProductsBean", pb);
			return "insertproducts";
	}
		@RequestMapping(value = "/products/add", method = RequestMethod.POST)
		public String proccessinsertProduct(@ModelAttribute("ProductsBean") ProductsBean pb) {
			service.insertProduct(pb);
			return "redirect:/products";
		}
}
