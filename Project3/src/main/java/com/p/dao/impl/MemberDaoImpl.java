package com.p.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.p.dao.MemberDao;
import com.p.model.MemberBean;

public class MemberDaoImpl implements MemberDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public MemberBean register(MemberBean mb) {
		
		return null;
	}

	@Override
	public MemberBean queryMember(String account) {
		
		return null;
	}

	@Override
	public MemberBean updateMember(MemberBean mb) {
		
		return null;
	}

}
