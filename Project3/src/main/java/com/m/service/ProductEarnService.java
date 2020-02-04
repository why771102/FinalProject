package com.m.service;

import java.util.List;

import com.m.model.ProductSaleEarnBean;

public interface ProductEarnService {
	public String getCategoryNames();
	public List<ProductSaleEarnBean> getAllProductInfo(String sDate, String eDate);
	public List<ProductSaleEarnBean> getAllFoodInfo(String sDate, String eDate);
	public List<ProductSaleEarnBean> getFoodInfo4(String sDate, String eDate);
	public List<ProductSaleEarnBean> getFoodInfo5(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo6(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo7(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo8(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo9(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo10(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo11(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo12(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo13(String sDate, String eDate);
	
	public List<ProductSaleEarnBean> getInfoByDate(Integer productID, String sDate, String eDate);
	public String getPname(Integer productID);
//	public List<LocalDate> getFoodDates();
}
