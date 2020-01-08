package com.c.dao.impl;

import java.sql.Date;
import java.util.List;

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
	public List<NumberOfSeatsBean> getNumberOfSeats(Date date) {
		Session session = factory.getCurrentSession();
		
		return null;
	}
	
	


}
