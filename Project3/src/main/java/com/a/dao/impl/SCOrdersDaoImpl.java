package com.a.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.SCOrdersDao;
import com.a.model.SCOrdersBean;
import com.a.model.ShippingStatusBean;
import com.p.model.MemberBean;
import com.p.model.PayStatusBean;

@Repository
public class SCOrdersDaoImpl implements SCOrdersDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void insertOrder(SCOrdersBean scob) {
		Session session = factory.getCurrentSession();
		MemberBean mb = getMemberBeanById(scob.getMemberID());
		ShippingStatusBean ssb = getShippingStatusBeanById(0);
		PayStatusBean psb = getPayStatusBeanById(0);
		String today = LocalDate.now().toString();
		System.out.println(mb.getAddress());
		scob.setShippingAddress(mb.getAddress());
		scob.setOrderDate(today);
		scob.setTotal(0);
		scob.setMemberBean(mb);
		scob.setShippingStatusBean(ssb);
		scob.setPayStatusBean(psb);
		session.save(scob);
	}

	@Override
	public MemberBean getMemberBeanById(Integer memberID) {
		Session session = factory.getCurrentSession();
		MemberBean mb = session.get(MemberBean.class, memberID);
		return mb;
	}

	@Override
	public ShippingStatusBean getShippingStatusBeanById(Integer shippingStatusID) {
		Session session = factory.getCurrentSession();
		ShippingStatusBean ssb = session.get(ShippingStatusBean.class, shippingStatusID);
		return ssb;
	}

	@Override
	public PayStatusBean getPayStatusBeanById(Integer paymentStatusID) {
		Session session = factory.getCurrentSession();
		PayStatusBean psb = session.get(PayStatusBean.class, paymentStatusID);
		return psb;
	}

	@Override
	public SCOrdersBean getOrder(Integer SCOrderID) {
		Session session = factory.getCurrentSession();
		SCOrdersBean SCob = session.get(SCOrdersBean.class, SCOrderID);
//		String hql = "FROM SCOrdersBean WHERE SCOrderID = :SCOrderID AND paymentStatus = :paymentStatus";
//		SCOrdersBean SCob = (SCOrdersBean) session.createQuery(hql).setParameter("SCOrderID", SCOrderID)
//							.setParameter("paymentStatus", Status)
//							.getSingleResult();
		return SCob;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SCOrdersBean> getMemberOrders(String memberID, Integer paymentStatus) {
		Session session = factory.getCurrentSession();
		List<SCOrdersBean> list = new ArrayList<>();
		String hql = "FROM SCordersBean WHERE memberID = :memberID AND paymentStatus = :paymentStatus";
		list = session.createQuery(hql).setParameter("memberID", memberID).setParameter("paymentStatus", paymentStatus)
				.getResultList();
		return list;
	}

	@Override
	public boolean updateStatus(SCOrdersBean ob) {
		Session session = factory.getCurrentSession();
		return false;
	}

}
