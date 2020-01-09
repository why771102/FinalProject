package com.l.dao;

import java.util.List;

import com.c.model.HallBean;

public interface ProductsDao {
	//查詢單個產品
	public HallBean getProduct(Integer productID);

	//查詢所有產品
	public List<HallBean> getProducts(Integer status);

	//更新產品
	public void updateProduct(Integer hallID, Integer status);
	//新增產品
	public void insertProduct(HallBean hb);
	//修改產品
	public void updateProduct(HallBean hb);
}
