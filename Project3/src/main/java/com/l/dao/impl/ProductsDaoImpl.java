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
	
	///用productID查詢
	@Override
	@SuppressWarnings("unchecked")
	public ProductsBean getProduct(Integer productID) {
		Session session = factory.getCurrentSession();
		ProductsBean hb = session.get(ProductsBean.class, productID);
		return hb;
	}

	@Override
	public List<ProductsBean> getProducts() {
		String hql="from ProductsBean";
		Session session=null;
		List<ProductsBean> list=new ArrayList<>();
		session = factory.getCurrentSession();
		list=session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void updateProduct(Integer productID, String productName, Integer category, Integer unitPrice,
			Integer unitStock, Integer cost) {
		String hql="UPDATE ProductsBean SET productName=:newproductName, category=:newcategory, unitPrice=:newunitPrice, unitStock=:newunitStock, cost=:newcost WHERE productID=:id";
		Session session=factory.getCurrentSession();
			int n=session.createQuery(hql)	
					.setParameter("newproductName", productName)
					.setParameter("newcategory", category)
					.setParameter("newunitPrice", unitPrice)
					.setParameter("newunitStock", unitStock)
					.setParameter("newcost", cost)
					.executeUpdate();
	}

	@Override
	public void insertProduct(Integer productID, String productName, Integer category, Integer unitPrice,
			Integer unitStock, Integer cost) {
		
		
	}


	



}
