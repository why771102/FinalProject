package com.p.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.p.dao.HallOrderDao;
import com.p.model.HallOrderBean;

@Repository
public class HallOrderDaoImpl implements HallOrderDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	

	@Override
	public HallOrderBean hallOrderApply(HallOrderBean Hob) {
		Session session = factory.getCurrentSession();
		session.save(Hob);
		return null;
	}
	
	//用戶自行查詢包廳狀況，用MemberID去找
	@Override
	public List<HallOrderBean> hallOrderMQuery(Integer MemberID) {
		String hql = "From HallOrderBean h Where h.memberID = :memberID";
		Session session = factory.getCurrentSession();
		List<HallOrderBean> list = new ArrayList<>();
		session.createQuery(hql).setParameter("memberID", MemberID).getResultList();
		return list;
	}

	//後臺功能，讓員工可查詢一段時間內的包廳申請
	@Override
	public List<HallOrderBean> hallOrderEQuery() {
		String hql = "From HallOrderBean";
		Session session = factory.getCurrentSession();
		List<HallOrderBean> list = new ArrayList<>();
		session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public HallOrderBean hallOrderStatusChange() {
		
		return null;
	}

	@Override
	public HallOrderBean payStatusChange() {
		
		return null;
	}




}
