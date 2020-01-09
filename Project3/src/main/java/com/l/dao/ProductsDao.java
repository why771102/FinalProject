package com.l.dao;

import java.util.List;

import com.c.model.HallBean;

public interface ProductsDao {
	//查詢單個產品
	public HallBean getProduct(Integer productID);

	//查詢所有產品
	public List<HallBean> getProducts();

	//更新產品
	public void updateProduct(Integer productID,String productName,Integer category,Integer unitPrice,Integer unitStock,Integer cost);
	//新增產品
	public void insertProduct(Integer productID,String productName,Integer category,Integer unitPrice,Integer unitStock,Integer cost);
	

}
