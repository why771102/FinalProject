package com.c.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.dao.NumberOfSeatsDao;
import com.c.model.HallBean;
import com.c.model.NumberOfSeatsBean;

@Repository
public class NumberOfSeatsDaoImpl implements NumberOfSeatsDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void insertNumberofSeats(NumberOfSeatsBean nosb) {
		Session session = factory.getCurrentSession();
		HallBean hb = getHallById(nosb.getHallID());
		nosb.setHallBean(hb);
		session.save(nosb);

	}

	@Override
	public HallBean getHallById(String hallID) {
		Session session = factory.getCurrentSession();
		HallBean hb = session.get(HallBean.class, hallID);
		return hb;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NumberOfSeatsBean> getNumberOfSeats(Date date) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NumberOfSeatsBean WHERE Date= :date";
		List<NumberOfSeatsBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("date", date).getResultList();
		return list;
	}

	
	
	


}
