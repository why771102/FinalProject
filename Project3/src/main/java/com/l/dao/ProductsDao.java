package com.l.dao;

import java.util.List;

import com.c.model.HallBean;
import com.l.model.ProductsBean;

public interface ProductsDao {
	//查詢單個產品
	public ProductsBean getProduct(Integer productID);

	//查詢所有產品
	public List<ProductsBean> getProducts();

	//查詢分類產品們
	public List<String> getCategories();
	//用ID查詢分類產品 
	public List<ProductsBean> getCategory(Integer category);
	
	//更新產品
	public void updateProduct(Integer productID,String productName,Integer category,Integer unitPrice,Integer unitStock,Integer cost);
	//新增產品
	public void insertProduct(Integer productID,String productName,Integer category,Integer unitPrice,Integer unitStock,Integer cost);
	

}
