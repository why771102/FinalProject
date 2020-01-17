package com.m.dao;

import java.util.List;

import com.m.model.ProductSaleBean;

public interface ProductSaleDao {
	
	//show all food orders
	public List<ProductSaleBean> showAllFoodOrders(String playStartTimeA, String playStartTimeB);
	//show all peripheral orders
	public List<ProductSaleBean> getPeripheralOrders(String orderDateA, String orderDateB);
	//4, 5
	public List<ProductSaleBean> showFoodOrder(String categoryName, String playStartTimeA, String playStartTimeB);
	//4+5
	public List<ProductSaleBean> showFoodOrders(String categoryNameA, String categoryNameB, String playStartTimeA, String playStartTimeB);
	// 6, 7, 8.. (DBT: SCOrderDetail(QTY), mOrderDetail(price, discount?), SCOrders(total))
	public List<ProductSaleBean> showPeripheralOrder(String categoryName, String orderDateA, String orderDateB);
	//6+7+8..
	public List<ProductSaleBean> showPeriperalOrders(String categoryNameA, String categoryNameB, String orderDateA, String orderDateB);
	
	public List<String> getDistinctProductNames();
	
	//根據產品名稱進入單日資訊
	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB);
	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB);
	
	//DBT:products => productID, productName, category(4套票(飲食), 5飲食, 6~線上商城)
	//DBT: showTimeHistory => showTimeID, playStartTime
	//DBT: products & mOrderDetail, products & SCOrderDetail (PID)
	//DBT: mOrderDetail => productID, unitPrice, quantity, discount
	//DBT: SCOrderDetail => SCOrderID, productID, quantity, unitPrice, discount
	//DBT: SCOrders => orderDate(String), total
}
