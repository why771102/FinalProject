package com.m.service;

import java.time.LocalDate;
import java.util.List;
import com.m.model.ProductSaleEarnBean;

public interface ProductEarnService {
	public String getCategoryNames();
	public List<ProductSaleEarnBean> getAllProductInfo(String sDate, String eDate);
	public List<ProductSaleEarnBean> getAllFoodInfo(String sDate, String eDate);
	public List<ProductSaleEarnBean> getFoodInfo4(String sDate, String eDate);
	public List<ProductSaleEarnBean> getFoodInfo5(String sDate, String eDate);
	public List<ProductSaleEarnBean> getPeripheralInfo(String sDate, String eDate);
	
	public List<ProductSaleEarnBean> getInfoByDate(String pName, String sDate, String eDate);
	
	public List<LocalDate> getFoodDates();
}
