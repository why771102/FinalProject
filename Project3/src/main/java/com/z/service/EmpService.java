package com.z.service;

import java.util.List;

import com.z.model.EmpBean;
import com.z.model.RoleBean;

public interface EmpService {

	void saveEmp(EmpBean eb);
	
	void updateEmp(EmpBean eb);
	
	EmpBean isExists(EmpBean mb);
	
	List<EmpBean> findAllEmps();

	EmpBean getEmp(Integer empId);

	List<RoleBean> getRoleList();
	
	
	
}
