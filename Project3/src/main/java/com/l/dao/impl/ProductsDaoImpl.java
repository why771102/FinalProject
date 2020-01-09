package com.l.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.l.dao.ProductsDao;
import com.l.model.ProductsBean;

@Repository
public class ProductsDaoImpl implements ProductsDao{
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public ProductsBean getProduct(Integer productID) {
		Session session = factory.getCurrentSession();
		ProductsBean hb = session.get(ProductsBean.class, productID);
		return hb;
	}


	



}
