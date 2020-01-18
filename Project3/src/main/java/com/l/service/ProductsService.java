package com.l.service;

import java.util.List;

import com.l.model.ProductsBean;

public interface ProductsService {

		//查詢單個產品
		public ProductsBean getProduct(Integer productID);

		//查詢所有產品
		public List<ProductsBean> getProducts();

		//查詢分類產品們
		public List<String> getCategories();
		//用ID查詢分類產品 
		public List<ProductsBean> getCategory(Integer categoryID);
		
		//更新產品們
		public void updateProducts(ProductsBean product);
		
		//新增產品
		public void insertProduct(ProductsBean product);
		
}
