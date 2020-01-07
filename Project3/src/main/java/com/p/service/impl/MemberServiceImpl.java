package com.p.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p.dao.MemberDao;
import com.p.model.MemberBean;
import com.p.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	MemberDao dao;
	
	@Autowired
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public MemberBean register(MemberBean mb) {
		return dao.register(mb);
	}
	
	@Transactional
	@Override
	public boolean accountExists(String account) {
		return dao.accountExists(account);//不確定
	}
	
	@Transactional
	@Override
	public boolean UIDExists(String UID) {
		return dao.UIDExists(UID);//不確定
	}

	@Transactional
	@Override
	public MemberBean checkIdPassword(String account, String password) {
		return dao.checkIdPassword(account, password);
	}

	@Transactional
	@Override
	public MemberBean queryMember(String account) {
		return dao.queryMember(account);
	}

	@Transactional
	@Override
	public MemberBean updateMember(MemberBean mb) {	
		return dao.updateMember(mb);
	}

}
