package com.z.service;

import java.util.List;

import com.z.model.QuestionBean;
import com.z.model.QuestionContentBean;

public interface QuestionContentService {

	public List<QuestionContentBean> historyContent(Integer questionId);

}
