package com.t.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p.model.MemberBean;
import com.t.dao.PreferenceDao;
import com.t.model.PreferenceBean;
import com.t.service.PreferenceService;

@Service
public class PreferenceServiceImpl implements PreferenceService{
	PreferenceDao dao;
	
	@Transactional
	@Autowired
	public void setDao(PreferenceDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public boolean checkLikeExist(Integer MemberID, Integer CommentID) {
		return dao.checkLikeExist(MemberID, CommentID);
	}	
	
	@Transactional
	@Override
	public MemberBean getMemberById(int memberID) {
		return dao.getMemberById(memberID);
	}
	
	@Transactional
	@Override
	public MemberBean getCommentById(int commentID) {
		return dao.getMemberById(commentID);
	}
	
//	@Transactional
//	@Override
//	public List<MemberBean> getMemberList() {
//		return dao.getMemberList();
//	}
	
	@Transactional
	@Override
	public void addLike(PreferenceBean pb) {
		dao.addLike(pb);
	}

}

