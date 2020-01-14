package com.l.dao;

import java.util.List;

import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.l.model.ProductsBean;

public interface mOrderDao {
	//查詢票
	public List<MOrderBean> getTickets();
	//存場地ID需要用到的方法
	public void getShowTimebyID(ShowTimeHistoryBean ShowTimeID);
	//更新產品
	public void updateProducts(ProductsBean product);
	//新增產品
	public void insertProduct(ProductsBean product);

}
