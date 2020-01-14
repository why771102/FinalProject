package com.m.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.model.HallBean;
import com.m.dao.HallSaleDao;
import com.m.model.HallSaleBean;
import com.p.model.HallOrderBean;

@Repository
public class HallSaleDaoImpl implements HallSaleDao {

	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HallOrderBean> getHallOrder() {
		String hql = "SELECT hallID, date, orderHours, hallSubtotal FROM hallOrder";
		Session session = factory.getCurrentSession();
		List<HallOrderBean> hob = new ArrayList<>();
		hob = session.createQuery(hql).getResultList();
		return hob;
	}

//	@Override
//	public List<HallBean> getHallBean(List<HallOrderBean> hobList) {
//		List<HallBean> hbList = new ArrayList<>();
//		
//		Session session = factory.getCurrentSession();
//		for(HallOrderBean hob : hobList) {
//			HallBean hb = null;
//			hb = session.get(HallBean.class, hob.getHallID());
//			hbList.add(hb);
//		}
//		return hbList;
//	}
	
}
