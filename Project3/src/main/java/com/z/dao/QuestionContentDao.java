package com.z.dao;

import java.util.List;

import com.z.model.QuestionContentBean;

public interface QuestionContentDao {
	
	public List<QuestionContentBean> historyContent(Integer questionId);
	
}