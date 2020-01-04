package com.z.dao;

import java.util.List;

import com.z.model.EmpBean;

public interface EmpDao {
	
	void saveMember(EmpBean mb);
	
	void updateMember(EmpBean mb);
	
	EmpBean isExists(EmpBean mb);
	
	List<EmpBean> findAllMember();
	
	
	

}
