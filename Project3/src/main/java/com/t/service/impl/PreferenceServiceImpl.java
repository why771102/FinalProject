package com.t.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.t.dao.PreferenceDao;
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
	
}

