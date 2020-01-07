package com.p.dao;

import com.p.model.MemberBean;

public interface MemberDao {
	//註冊，將前端填寫的資料寫進DB
	public MemberBean register(MemberBean mb);
	
	//以帳號進行會員資料查詢，之後要秀在前端
	public MemberBean queryMember(String account);
	
	//用戶更改資料後，存進DB
	public MemberBean updateMember(MemberBean mb);
	
	//看看二專登入跟登出是否放在同個Dao
}
