package com.t.dao;

import java.util.List;

import com.p.model.MemberBean;
import com.t.model.CommentBean;
import com.t.model.PreferenceBean;

public interface PreferenceDao {

	//抓出該會員是否在該留言執行過偏好設定
	public boolean checkLikeExist(Integer memberID, Integer commentID);
	
	//按讚 建立新欄位
	void addLike(PreferenceBean pb);
	
	//按噓 建立新欄位
	void addBad(PreferenceBean pb);
	
	//按屏蔽 建立新欄位
	void addBlock(PreferenceBean pb);
	
	//選擇memberID
	MemberBean getMemberById(int memberID);
	List<MemberBean> getMemberList();
	
	//抓commentID
	public CommentBean getCommentById(int commentID);
	
	//按讚 修改欄位
	void fixLike(Integer memberID, Integer commentID);
	
	//按讚 修改欄位	
	void fixBad(Integer memberID, Integer commentID);
	
	//按屏蔽 修改欄位
	void fixBlock(Integer memberID, Integer commentID);
	

	//屏蔽全部 到comment資料表抓出該短評的作者會員ID，列出該作者所有短評ID，再回到Preference 
	//建立新欄位，讚 噓 屏蔽設為0,0,1，若已有過設定，將屏蔽設為1

	//抓出每則短評的讚、噓總數

}
