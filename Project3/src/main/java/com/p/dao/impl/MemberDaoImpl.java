package com.p.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.p.dao.MemberDao;
import com.p.model.MemberBean;

@Repository
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

	@Override
	public boolean accountExists(String account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UIDExists(String UID) {
		
		return false;
	}

	@Override
	public MemberBean checkIdPassword(String account, String password) {
		
		return null;
	}

}
