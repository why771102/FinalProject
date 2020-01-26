package com.t.service;

import java.util.List;

import com.p.model.MemberBean;
import com.t.model.PreferenceBean;

public interface PreferenceService {

	public boolean checkLikeExist(Integer MemberID, Integer CommentID);
	
	//檢驗good欄位是否為1
	public boolean checkLikeTrue(Integer memberID, Integer commentID);
	
	//檢驗bad欄位是否為1
	public boolean checkDislikeTrue(Integer memberID, Integer commentID);
		
	//建立新欄位
	void addLike(PreferenceBean pb);
	
	//good,bad改成1,0
	public void addGood(Integer memberID, Integer commentID);
	
	//把good取消
	public void cancelGood(Integer memberID, Integer commentID);
	
	//good,bad改成0,1
	public void addBad(Integer memberID, Integer commentID);

	//把bad取消
	public void cancelBad(Integer memberID, Integer commentID);
	
	//按屏蔽 修改欄位
	void fixBlock(Integer memberID, Integer commentID);
	
	public MemberBean getMemberById(int memberID);
//	public List<MemberBean> getMemberList();
	
	public MemberBean getCommentById(int commentID);	
	
}
