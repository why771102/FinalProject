package com.a.service;

import java.util.List;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.l.model.ProductsBean;

public interface SCOrderDetailsService {
	
	public void insertOrderDetails(SCOrderDetailBean scodb);

	public SCOrdersBean getSCOrdersBeanByID(Integer SCOrderID);
	
	public ProductsBean getProductsBeanByID(Integer productID);	
	
	public List<SCOrderDetailBean> getOrderDetails(Integer SCOrderID);
}
