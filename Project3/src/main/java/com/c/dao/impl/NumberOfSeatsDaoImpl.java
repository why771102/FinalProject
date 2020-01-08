package com.c.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.dao.NumberOfSeatsDao;
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
		session.save(nosb);

	}

	@Override
	public NumberOfSeatsBean getNumberOfSeats(String hallID) {
		Session session = factory.getCurrentSession();
		NumberOfSeatsBean nosb = session.get(NumberOfSeatsBean.class, hallID);
		return nosb;
	}


}
