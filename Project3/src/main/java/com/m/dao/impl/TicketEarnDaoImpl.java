package com.m.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.m.dao.TicketEarnDao;

public class TicketEarnDaoImpl implements TicketEarnDao {
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
}
