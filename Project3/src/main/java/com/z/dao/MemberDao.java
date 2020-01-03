package com.z.dao;

import java.util.List;

import com.z.model.MemberBean;

public interface MemberDao {
	
	void saveMember(MemberBean mb);
	
	void updateMember(MemberBean mb);
	
	MemberBean isExists(MemberBean mb);
	
	List<MemberBean> findAllMember();
	
	
	

}
