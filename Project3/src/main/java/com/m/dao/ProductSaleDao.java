package com.m.dao;

import java.time.LocalDate;
import java.util.List;
import com.m.model.ProductSaleBean;

public interface ProductSaleDao {
	
	//show all food orders
	public List<ProductSaleBean> showAllFoodOrders(String playStartTimeA, String playStartTimeB);
	//show all peripheral orders
	public List<ProductSaleBean> showPeripheralOrders(String orderDateA, String orderDateB);
	//4, 5
	public List<ProductSaleBean> showFoodOrder(Integer category, String playStartTimeA, String playStartTimeB);
	//4+5
	public List<ProductSaleBean> showFoodOrders(Integer categoryA, Integer categoryB, String playStartTimeA, String playStartTimeB);
	// 6, 7, 8.. (DBT: SCOrderDetail(QTY), mOrderDetail(price, discount?), SCOrders(total))
	public List<ProductSaleBean> showPeripheralOrder(Integer category, String orderDateA, String orderDateB);
	//6+7+8..
	public List<ProductSaleBean> showPeriperalOrders(Integer categoryA, Integer categoryB, String orderDateA, String orderDateB);
	
	public List<String> getDistinctProductNames();
	
	//根據產品名稱進入單日資訊
	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB);
	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB);
	public List<LocalDate> showEachDate(String sDate, String eDate);
	
	//DBT:products => productID, productName, category(4套票(飲食), 5飲食, 6~線上商城)
	//DBT: showTimeHistory => showTimeID, playStartTime
	//DBT: products & mOrderDetail, products & SCOrderDetail (PID)
	//DBT: mOrderDetail => productID, unitPrice, quantity, discount
	//DBT: SCOrderDetail => SCOrderID, productID, quantity, unitPrice, discount
	//DBT: SCOrders => orderDate(String), total
}
