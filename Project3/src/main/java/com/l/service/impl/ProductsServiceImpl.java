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
	
	//查詢單
	@Transactional
	@Override
	public ProductsBean getProduct(Integer productID) {
		return dao.getProduct(productID);
	}

	//查詢多
	@Transactional
	@Override
	public List<ProductsBean> getProducts() {
		return dao.getProducts();
	}
	
	//查詢分類產品們
	@Transactional
	@Override
	public List<String> getCategories() {
		return dao.getCategories();
	}
	//用ID查詢分類產品 
	@Transactional
	@Override
	public List<ProductsBean> getCategory(Integer category) {
		return dao.getCategory(category);
	}
	
	//修改
	@Transactional
	@Override
	public void updateProducts(ProductsBean product) {
	 dao.updateProducts(product);
	}
	
	//新增
	@Transactional
	@Override
	public void insertProduct(ProductsBean product) {
		dao.insertProduct(product);
		
	}



}
