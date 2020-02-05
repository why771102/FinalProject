package com.p.service.impl;

import java.util.List;

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
	public void register(MemberBean mb) {
		dao.register(mb);
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
	public MemberBean queryMember(Integer memberID) {
		return dao.queryMember(memberID);
	}

	@Transactional
	@Override
	public void updateMember(MemberBean mb) {	
		dao.updateMember(mb);
	}
	
	@Transactional
	@Override
	public void updateLastLoginTime(String lastLoginTime, Integer memberID) {
		dao.updateLastLoginTime(lastLoginTime, memberID);
	}

	@Transactional
	@Override
	public List<MemberBean> getMemberList() {
		return dao.getMemberList();
	}

	@Transactional
	@Override
	public MemberBean getEmployeeMember(String uID) {
		return dao.getEmployeeMember(uID);
	}

}
