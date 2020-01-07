package com.p.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.p.dao.HallOrderDao;
import com.p.model.HallOrderBean;

public class HallOrderDaoImpl implements HallOrderDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	

	@Override
	public HallOrderBean hallOrderApply(HallOrderBean Hob) {
		
		return null;
	}
	
	@Override
	public HallOrderBean hallOrderMQuery(Integer MemberID) {
		
		return null;
	}

	@Override
	public HallOrderBean hallOrderEQuery() {
		
		return null;
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
