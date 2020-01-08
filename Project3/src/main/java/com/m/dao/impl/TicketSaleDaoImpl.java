package com.m.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.a.model.showTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.m.dao.TicketSaleDao;

public class TicketSaleDaoImpl implements TicketSaleDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public List<NumberOfSeatsBean> getHallSeat(Date date){
		
		String hql = "FROM numberOfSeats nos WHERE nos.date=? and nos.hallID=?";
		
		Session session = factory.getCurrentSession();
		
		return null;
	}
	
	
}
