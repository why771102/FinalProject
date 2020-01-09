package com.l.service;

import java.util.List;

import com.l.model.ProductsBean;

public interface ProductsService {

		//查詢單個產品
		public ProductsBean getProduct(Integer productID);

		//查詢所有產品
		public List<ProductsBean> getProducts();

		//更新產品
		public void updateProduct(Integer productID,String productName,Integer category,Integer unitPrice,Integer unitStock,Integer cost);
		//新增產品
		public void insertProduct(Integer productID,String productName,Integer category,Integer unitPrice,Integer unitStock,Integer cost);
		
}
