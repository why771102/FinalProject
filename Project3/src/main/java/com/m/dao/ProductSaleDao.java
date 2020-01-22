package com.m.dao;

import java.time.LocalDate;
import java.util.List;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.model.ProductSaleBean;
import com.m.model.ProductSaleEarnBean;

public interface ProductSaleDao {
	//get categoryNames as select option
	public String getCategoryNames();
	//default and all
	public List<ProductSaleEarnBean> getAllProductInfo(String sDate, String eDate);
	//all food
	public List<ProductSaleEarnBean> getAllFoodInfo(String sDate, String eDate);
	public List<ProductSaleEarnBean> getFoodInfo4(String sDate, String eDate);
	public List<ProductSaleEarnBean> getFoodInfo5(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo(String sDate, String eDate);
	

	public List<LocalDate> getFoodDates();
//	public List<MOrderBean> getFoodSCOrder();
//	public List<LocalDate> getPeripheralDates();
//	public List<SCOrdersBean> getPeripheralSCOrder(LocalDate orderDate);
//	public List<SCOrderDetailBean> getPeripheralSCODs(List<SCOrdersBean> scbList);
//	public List<ProductSaleEarnBean> getPeripheralPBs(List<SCOrderDetailBean> scodList);

	//show all peripheral orders
	public List<SCOrdersBean> getPeripheralSCOrders(String orderDateA, String orderDateB);
	public List<ProductsBean> getPeripheralPB();
	public List<ProductSaleBean> getPeripheralSCOD(List<ProductsBean> pbList, List<SCOrdersBean> scbList);
//	public List<ProductSaleBean> getPeripheralOrders(String orderDateA, String orderDateB);
	//4, 5, 4+5
	public List<ShowTimeHistoryBean> getMovieDate(String playStartTimeA, String playStartTimeB);
	public List<MOrderDetailBean> getMODBList();
	public List<ProductsBean> getFoodPB4();
	public List<ProductsBean> getFoodPB5();
	public List<ProductsBean> getAllFoodPB();
	public List<ProductSaleBean> showFoodOutput(List<ShowTimeHistoryBean> sthbList, List<MOrderDetailBean> modbList,
			List<ProductsBean> pbList);
	//取得相對應的CID判斷
	public Integer getCategory(String pName);
	

//	public List<String> getDistinctProductNames();
	
	//根據產品名稱進入單日資訊
//	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB);
//	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB);
}
