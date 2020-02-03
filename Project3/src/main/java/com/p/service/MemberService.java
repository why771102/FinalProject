package com.p.service;

import java.util.List;

import com.p.model.MemberBean;

public interface MemberService {
	//註冊，將前端填寫的資料寫進DB
	public void register(MemberBean mb);
	
	//判斷帳號是否已被使用
	public boolean accountExists(String account);
	
	//判斷身分證字號是否被使用過
	public boolean UIDExists(String UID);
	
	//判斷帳號密碼是否正確(要記得進行加密來比對吧?)
	public MemberBean checkIdPassword(String account, String password);	
	
	//以帳號進行會員資料查詢，之後要秀在前端
	public MemberBean queryMember(Integer memberID);
	
	//用戶更改資料後，存進DB
	public void updateMember(MemberBean mb);
	
	//寫入最後登入時間
	public void updateLastLoginTime(String lastLoginTime, Integer memberID);
	
	public List<MemberBean> getMemberList();
}
