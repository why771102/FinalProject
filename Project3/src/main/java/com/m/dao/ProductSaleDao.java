package com.m.dao;

import java.util.List;
import com.m.model.ProductSaleBean;

public interface ProductSaleDao {
	
	//DBT:products => productID, productName, category(4套票(飲食), 5飲食, 6~線上商城)
//	public List<ProductsBean> getProductsInfo(Integer category, String orderDate);
//	public Integer getProductID(Integer category);
//	public String getProductName(Integer ProductID);
	
	//DBT: showTimeHistory => showTimeID, playStartTime
//	public Timestamp getPlayStartTime(Integer showTimeID);
	
	//DBT: products & mOrderDetail, products & SCOrderDetail (PID)
//	public List<String> getProductsName(String orderDate);
//	public List<String> getPeripheralsName(Timestamp orderDate);
	
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
	
//
//	public List<ProductSaleBean> showDailyFoodOrder(String productName);
	//根據產品名稱進入單日資訊
	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB);
	public List<ProductSaleBean> showPeriperalOrderByTime(String productName, String orderDateA, String orderDateB);
	//DBT: SCOrderDetail => SCOrderID, productID, quantity
//	public List<SCOrderDetailBean> getPeripheralsOD(Integer productID);
	
	//DBT: SCOrders => orderDate(timestamp), total
//	public SCOrdersBean getPeripheralsOrder(Integer SCOrderID);
	
}
