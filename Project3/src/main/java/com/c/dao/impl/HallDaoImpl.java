package com.c.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.c.dao.HallDao;
import com.c.model.HallBean;

public class HallDaoImpl implements HallDao{
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public HallBean getHall(String hallName) {
		Session session = factory.getCurrentSession();
		HallBean hb = session.get(HallBean.class, hallName);
		return hb;
	}

//	@Override
//	public Integer getNumberOfSeats(Integer hallID) {
//		Session session = factory.getCurrentSession();
//		HallBean hb = session.get(HallBean.class, hallID);
//		Integer seats = hb.getNoOfSeats();
//		return seats;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HallBean> getAllHalls(Integer status) {
		List<HallBean> list = new ArrayList<>();
		String hql = "FROM HallBean hb WHERE hb.status= :hbs";
		Session session = factory.getCurrentSession();
		
		list = session.createQuery(hql)
				.setParameter("hbs", status)
				.list();
		return list;
	}

//	@Override
//	public Integer getPrice(Integer hallID) {
//		Session session = factory.getCurrentSession();
//		HallBean hb = session.get(HallBean.class, hallID);
//		Integer price = hb.getPrice();
//		return price;
//	}

	@Override
	public void updateStatus(Integer hallId, Integer status) {
		Session session = factory.getCurrentSession();
		HallBean hb = session.get(HallBean.class, hallId);
		hb.setStatus(status);
		session.saveOrUpdate(hb);
	}

	@Override
	public void insertHall(HallBean hb) {
		Session session = factory.getCurrentSession();
		session.save(hb);
	}

}
