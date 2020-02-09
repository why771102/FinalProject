package com.z.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z.dao.AnnoDao;
import com.z.dao.QuestionDao;
import com.z.model.AnnoBean;
import com.z.model.AnnoStatusBean;
import com.z.model.QuestionBean;
import com.z.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	QuestionDao dao;
	
	@Transactional
	@Autowired
	public void setDao(QuestionDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<QuestionBean> allQuestion(Integer memberId) {
		return dao.allQuestion(memberId);
	}
	@Transactional
	@Override
	public Integer newQuestion(Integer memberId) {
		return dao.newQuestion(memberId);
		
	}
	@Transactional
	@Override
	public boolean checkMember(Integer memberId, Integer questionId) {
		return dao.checkMember(memberId, questionId);
	}

	@Transactional
	@Override
	public List<QuestionBean> allQuestionForEmp() {
		return dao.allQuestionForEmp();
	}
	
	@Transactional
	@Override
	public void closeQuestion(Integer questionId) {
		dao.closeQuestion(questionId);
		
	}
	
	@Transactional
	@Override
	public void openQuestion(Integer questionId) {
		dao.openQuestion(questionId);
		
	}
	
	@Transactional
	@Override
	public QuestionBean question(Integer questionId) {
		return dao.question(questionId);
	}

}
