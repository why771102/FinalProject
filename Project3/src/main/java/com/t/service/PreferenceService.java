package com.t.service;

import java.util.List;

import com.p.model.MemberBean;
import com.t.model.PreferenceBean;

public interface PreferenceService {

	public boolean checkLikeExist(Integer MemberID, Integer CommentID);
	
	//按讚 建立新欄位
	void addLike(PreferenceBean pb);
	
	//按噓 建立新欄位
	void addBad(PreferenceBean pb);
		
	//按屏蔽 建立新欄位
	void addBlock(PreferenceBean pb);
	
	public MemberBean getMemberById(int memberID);
	public List<MemberBean> getMemberList();
	
	public MemberBean getCommentById(int commentID);	
	
}
