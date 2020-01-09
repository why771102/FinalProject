package com.l.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.l.dao.ProductsDao;
import com.l.model.ProductsBean;
import com.l.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{
	ProductsDao dao;
	
	@Autowired
	public void setDao(ProductsDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public ProductsBean getProduct(Integer productID) {
		return dao.getProduct(productID);
	}

	@Transactional
	@Override
	public List<ProductsBean> getProducts() {
		return dao.getProducts();
	}
	
	@Transactional
	@Override
	public void updateProduct(Integer productID, String productName, Integer category, Integer unitPrice,
			Integer unitStock, Integer cost) {
		
		
	}
	
	@Transactional
	@Override
	public void insertProduct(Integer productID, String productName, Integer category, Integer unitPrice,
			Integer unitStock, Integer cost) {
		
		
	}

}
