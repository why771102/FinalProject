package com.t.dao;

import java.util.List;

import com.p.model.MemberBean;
import com.t.model.CommentBean;
import com.t.model.PreferenceBean;

public interface PreferenceDao {

	//抓出該會員是否在該留言執行過偏好設定
	public boolean checkLikeExist(Integer memberID, Integer commentID);
	
	//抓出他填入過的Like
//	public PreferenceBean getLike(Integer good);
	
	//檢驗good欄位是否為1
	public boolean checkLikeTrue(Integer memberID, Integer commentID);
	
	//檢驗bad欄位是否為1
	public boolean checkDislikeTrue(Integer memberID, Integer commentID);
	
	//建立新欄位
	void addLike(PreferenceBean pb);	
	
	//good,bad改成1,0
	public void addGood(Integer memberID, Integer commentID);
	
	//把讚噓取消
	public void cancel(Integer memberID, Integer commentID);
	
	//good,bad改成0,1
	public void addBad(Integer memberID, Integer commentID);

	//抓memberID
	MemberBean getMemberById(int memberID);
//	List<MemberBean> getMemberList();
	
	//抓commentID
	public CommentBean getCommentById(int commentID);
	
	//按屏蔽 修改欄位
	void fixBlock(Integer memberID, Integer commentID);

	//屏蔽全部 到comment資料表抓出該短評的作者會員ID，列出該作者所有短評ID，再回到Preference 
	//建立新欄位，讚 噓 屏蔽設為0,0,1，若已有過設定，將屏蔽設為1

	//抓出每則短評的讚數
	public List<PreferenceBean> findAllGood();
	
	//抓出每則短評的噓數
	public List<PreferenceBean> findAllBad();
	
}
