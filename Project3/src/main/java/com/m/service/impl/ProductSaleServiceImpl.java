package com.m.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.m.dao.ProductSaleDao;
import com.m.model.ProductSaleBean;
import com.m.service.ProductSaleService;

@Service
public class ProductSaleServiceImpl implements ProductSaleService {

	ProductSaleDao dao;
	
	@Autowired
	public void setDao(ProductSaleDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public List<ProductSaleBean> showAllFoodOrders(String playStartTimeA, String playStartTimeB) {
		return dao.showAllFoodOrders(playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showPeriperalOrders(String orderDateA, String orderDateB) {
		return dao.showPeriperalOrders(orderDateA, orderDateB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showFoodOrder(Integer category, String playStartTimeA, String playStartTimeB) {
		return dao.showFoodOrder(category, playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showFoodOrders(Integer categoryA, Integer categoryB, String playStartTimeA,
			String playStartTimeB) {
		return dao.showFoodOrders(categoryA, categoryB, playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showPeriperalOrder(Integer category, String orderDateA, String orderDateB) {
		return dao.showPeriperalOrder(category, orderDateA, orderDateB);
	}
	
	@Transactional
	@Override
	public List<ProductSaleBean> showPeriperalOrders(Integer categoryA, Integer categoryB, String orderDateA,
			String orderDateB) {
		return dao.showPeriperalOrders(categoryA, categoryB, orderDateA, orderDateB);
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB) {
		
		
		return null;
	}

}
