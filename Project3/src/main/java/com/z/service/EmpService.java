package com.z.service;

import java.util.List;

import com.z.model.EmpBean;

public interface EmpService {

	void saveEmp(EmpBean eb);
	
	void updateEmp(EmpBean eb);
	
	EmpBean isExists(EmpBean mb);
	
	List<EmpBean> findAllEmps();
	
	
	
}
