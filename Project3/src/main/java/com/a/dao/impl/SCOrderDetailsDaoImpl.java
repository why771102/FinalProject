package com.a.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.SCOrderDetailsDao;
import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.l.model.ProductsBean;

@Repository
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

//	@Override
//	public SCOrderDetailBean querySameProduct(Integer SCOrderID, SCOrderDetailBean scodb) {
//		SCOrderDetailBean scodb2 = new SCOrderDetailBean();
//		Session session = factory.getCurrentSession();
//		scodb2.setQuantity(0);
//		try {
//			String hql = "FROM SCOrderDetailBean WHERE SCOrderID = :SCOrderID and productID= :productID";
//			scodb2 = (SCOrderDetailBean) session.createQuery(hql).setParameter("SCOrderID", SCOrderID)
//					.setParameter("productID", scodb.getProductID()).getSingleResult();
//			return scodb2;
//		} catch (Exception e) {
//			System.out.println("並無放入過此商品進購物車");
//            return scodb2;
//		}
//	}


}
