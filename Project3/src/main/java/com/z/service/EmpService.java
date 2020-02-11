package com.z.service;

import java.util.List;

import com.z.model.EmpBean;
import com.z.model.EmpStatusBean;
import com.z.model.RoleBean;

public interface EmpService {

	void saveEmp(EmpBean eb);
	
//	void updateEmp(EmpBean eb);
	
	EmpBean isExists(EmpBean mb);
	
	List<EmpBean> findAllEmps();

	EmpBean getEmp(Integer empId);

	List<RoleBean> getRoleList();

	List<EmpStatusBean> getEmpStatusList();

	EmpBean login(String email, String password);
	
	String changeToMd5(String str);

	String changeFromMd5(String str);

	void changePwd(EmpBean eb);
	
	EmpBean getEmpFromEmail(String email);
	
}
