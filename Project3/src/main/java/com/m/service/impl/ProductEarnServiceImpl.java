package com.m.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.m.dao.ProductSaleDao;
import com.m.model.ProductSaleBean;
import com.m.model.ProductSaleEarnBean;
import com.m.service.ProductEarnService;
import com.m.service.ProductSaleService;

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
	public List<ProductSaleEarnBean> getInfoByDate(String pName, String sDate, String eDate) {
		return dao.getInfoByDate(pName, sDate, eDate);
	}

	@Override
	public List<LocalDate> getFoodDates() {
		return dao.getFoodDates();
	}
	


}
