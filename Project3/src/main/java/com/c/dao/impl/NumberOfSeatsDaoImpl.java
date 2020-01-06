package com.c.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.c.dao.NumberOfSeatsDao;
import com.c.model.NumberOfSeatsBean;

public class NumberOfSeatsDaoImpl implements NumberOfSeatsDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void insertNumberofSeats() {
		NumberOfSeatsBean nosb = new NumberOfSeatsBean();
		Session session = factory.getCurrentSession();
		
		String hql = "SELECT FROM Seats s GROUP BY ";

	}


}
