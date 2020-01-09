package com.m.service;

import java.util.List;

import com.m.model.ProductSaleBean;

public interface ProductSaleService {
	//DBT: mOrderDetail => productID, unitPrice, quantity, discount
	//show all food orders
	public List<ProductSaleBean> showAllFoodOrders(String playStartTimeA, String playStartTimeB);
	//show all peripheral orders
	public List<ProductSaleBean> showPeriperalOrders(String orderDateA, String orderDateB);
	//4, 5
	public List<ProductSaleBean> showFoodOrder(Integer category, String playStartTimeA, String playStartTimeB);
	//4+5
	public List<ProductSaleBean> showFoodOrders(Integer categoryA, Integer categoryB, String playStartTimeA, String playStartTimeB);
	// 6, 7, 8.. (DBT: SCOrderDetail(QTY), mOrderDetail(price, discount?), SCOrders(total))
	public List<ProductSaleBean> showPeriperalOrder(Integer category, String orderDateA, String orderDateB);
	//6+7+8..
	public List<ProductSaleBean> showPeriperalOrders(Integer categoryA, Integer categoryB, String orderDateA, String orderDateB);
	
	//根據產品名稱進入單日資訊
	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB);
}
