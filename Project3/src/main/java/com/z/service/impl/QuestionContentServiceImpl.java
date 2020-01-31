package com.z.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z.dao.QuestionContentDao;
import com.z.dao.QuestionDao;
import com.z.model.QuestionContentBean;
import com.z.service.QuestionContentService;

@Service
public class QuestionContentServiceImpl implements QuestionContentService {

	QuestionContentDao dao;
	
	@Transactional
	@Autowired
	public void setDao(QuestionContentDao dao) {
		this.dao = dao;
	}
	@Transactional
	@Override
	public List<QuestionContentBean> historyContent(Integer questionId) {
		return dao.historyContent(questionId);
	}
	
	@Transactional
	@Override
	public void saveMessage(QuestionContentBean ConBean) {
		dao.saveMessage(ConBean);	
	}

	
	

}
