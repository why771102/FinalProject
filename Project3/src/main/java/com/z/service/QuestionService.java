package com.z.service;

import java.util.List;

import com.z.model.QuestionBean;

public interface QuestionService {

	public Integer newQuestion(Integer memberId);

	// 用來顯示用戶至今所有提問清單
	public List<QuestionBean> allQuestion(Integer memberId);

	// 判斷該questionID是否是同一個member的
	public boolean checkMember(Integer memberId, Integer questionId);
	
	//用來顯示所有提問清單
	public List<QuestionBean> allQuestionForEmp();
	
	public void closeQuestion(Integer questionId);
	
	public void openQuestion(Integer questionId);
	
	public QuestionBean question(Integer questionId);

}
