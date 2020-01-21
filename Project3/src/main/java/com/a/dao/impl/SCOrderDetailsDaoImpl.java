package com.a.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.a.dao.SCOrderDetailsDao;
import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.l.model.ProductsBean;

public class SCOrderDetailsDaoImpl implements SCOrderDetailsDao {
	
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public void insertOrderDetails(SCOrderDetailBean scodb) {
		Session session = factory.getCurrentSession();
		SCOrdersBean scob = getSCOrdersBeanByID(scodb.getSCOrderID());
		ProductsBean pb = getProductsBeanByID(scodb.getProductID());
		scodb.setSCOrdersBean(scob);
		scodb.setProductsBean(pb);
		session.save(scodb);
	}
	

	@Override
	public SCOrdersBean getSCOrdersBeanByID(Integer SCOrderID) {
		Session session = factory.getCurrentSession();
		SCOrdersBean scob = session.get(SCOrdersBean.class, SCOrderID);
		return scob;
	}


	@Override
	public ProductsBean getProductsBeanByID(Integer productID) {
		Session session = factory.getCurrentSession();
		ProductsBean pb = session.get(ProductsBean.class, productID);
		return pb;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SCOrderDetailBean> getOrderDetails(Integer SCOrderID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SCOrderDetailBean WHERE SCOrderID = :SCOrderID";
		List<SCOrderDetailBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("SCOrderID", SCOrderID).getResultList();
		return list;
	}

	

}
