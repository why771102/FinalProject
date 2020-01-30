package com.z.dao;

import java.util.List;

import com.z.model.QuestionBean;

public interface QuestionDao {
	
	//創建新的question並回傳questionID
	public Integer newQuestion(Integer memberId);
	
	//用來顯示用戶至今所有提問清單
	public List<QuestionBean> allQuestion(Integer memberId);
	
	//判斷該questionID是否是同一個member的
	public boolean checkMember(Integer memberId, Integer questionId);
	
	//用來顯示所有提問清單
		public List<QuestionBean> allQuestionForEmp();
	
}