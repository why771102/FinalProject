package com.m.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m.dao.ProductSaleDao;
import com.m.model.ProductSaleEarnBean;
import com.m.service.ProductEarnService;

@Service
@Transactional
public class ProductEarnServiceImpl implements ProductEarnService {

	ProductSaleDao dao;
	
	@Autowired
	public void setDao(ProductSaleDao dao) {
		this.dao = dao;
	}
	
	@Override
	public String getCategoryNames() {
		return dao.getCategoryNames();
	}

	@Override
	public List<ProductSaleEarnBean> getAllProductInfo(String sDate, String eDate) {
		return dao.getAllProductInfo(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getAllFoodInfo(String sDate, String eDate) {
		return dao.getAllFoodInfo(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getFoodInfo4(String sDate, String eDate) {
		return dao.getFoodInfo4(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getFoodInfo5(String sDate, String eDate) {
		return dao.getFoodInfo5(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo(String sDate, String eDate) {
		return dao.getPeripheralInfo(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getInfoByDate(Integer productID, String sDate, String eDate) {
		return dao.getInfoByDate(productID, sDate, eDate);
	}

	@Override
	public String getPname(Integer productID) {
		return dao.getPname(productID);
	}

	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo6(String sDate, String eDate) {
		return dao.getPeripheralInfo6(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo7(String sDate, String eDate) {
		return dao.getPeripheralInfo7(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo8(String sDate, String eDate) {
		return dao.getPeripheralInfo8(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo9(String sDate, String eDate) {
		return dao.getPeripheralInfo9(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo10(String sDate, String eDate) {
		return dao.getPeripheralInfo10(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo11(String sDate, String eDate) {
		return dao.getPeripheralInfo11(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo12(String sDate, String eDate) {
		return dao.getPeripheralInfo12(sDate, eDate);
	}

	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo13(String sDate, String eDate) {
		return dao.getPeripheralInfo13(sDate, eDate);
	}

//	@Override
//	public List<LocalDate> getFoodDates() {
//		return dao.getFoodDates();
//	}
}
