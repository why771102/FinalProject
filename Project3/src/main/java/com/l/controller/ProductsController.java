package com.l.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.l.model.CategoriesBean;
import com.l.model.ProductsBean;
import com.l.service.ProductsService;
import com.z.model.EmpBean;
import com.z.model.RoleBean;


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
		model.addAttribute("Products", list);
		return "l/products";
	}
	
	//測試查詢多筆Ajax
	@RequestMapping(value = "/productsAjax" ,produces="application/json;charset=UTF-8;")
	public @ResponseBody String getProductsAjax(Model model) {
		List<ProductsBean> list=service.getProducts();
		model.addAttribute("Products", list);
		Gson gson = new Gson();
		String str = gson.toJson(list);
		return str;
	}
	
	//測試查詢單筆
	@RequestMapping("/product")
	public String getProduct(@RequestParam("productsID")Integer productID,Model model) {
		model.addAttribute("Product",service.getProduct(productID));
		return "l/product";
	}
	
	//測試更新方法*3  1.在查詢單筆內 2.丟到update頁面 3.丟回查單筆
	@RequestMapping(value = "/update/products/{productID}", method = RequestMethod.GET)
	public String proccessupdateProducts(@PathVariable("productID")Integer productID,Model model) {
		ProductsBean pb = service.getProduct(productID);
		model.addAttribute("ProductsBean", pb);
		return "l/updateproducts";
	}
	
	@RequestMapping(value = "/update/products/{productID}", method = RequestMethod.POST)
	public String proccessupdateProducts2(ProductsBean pb,Model model) {
		service.updateProducts(pb);
		return "redirect:/products";
	}

	@ModelAttribute("categoryList")
	public Map<Integer, String> getCategoryList() {
		Map<Integer, String> categoryMap = new HashMap<>();
		List<CategoriesBean> list = service.getCategoryList();
		for (CategoriesBean cb : list) {
			categoryMap.put(cb.getCategoryID(), cb.getCategoryName());
		}
		return categoryMap;
	}
	
	//測試查詢類別們
		@RequestMapping("/queryCategoriesID")
		public String queryCategoriesID(Model model) {
			List<String> list=service.getCategoriesID();
			model.addAttribute("CategoryList", list);
			return "l/category";
		}
		//測試查詢類別用ID 
			@RequestMapping("/products/{categoryID}")
				public String queryCategoryID(@PathVariable("categoryID")Integer categoryID,Model model) {
					List<ProductsBean> products=service.getCategoryID(categoryID);
					model.addAttribute("Products", products);
					return "l/products";
				}
	
			
			
	
		
	//測試新增方法*2       
		@RequestMapping(value = "/products/add", method = RequestMethod.GET)
		public String getinsertProduct(Model model) {
			ProductsBean pb = new ProductsBean();
			model.addAttribute("ProductsBean", pb);
			return "l/insertproducts";
	}
		@RequestMapping(value = "/products/add", method = RequestMethod.POST)
		public String proccessinsertProduct(@ModelAttribute("ProductsBean") ProductsBean pb) {
			service.insertProduct(pb);
			return "redirect:/products";
		}
}
