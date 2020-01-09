package com.z.dao;

import java.util.List;

import com.z.model.EmpBean;
import com.z.model.RoleBean;

public interface EmpDao {
	
	void saveEmp(EmpBean mb);
	
	void updateEmp(EmpBean mb);
	
	EmpBean isExists(EmpBean mb);
	
	List<EmpBean> findAllEmps();
	
	EmpBean getEmp(Integer empId);

	RoleBean getRoleById(Integer roleId);
	
	List<RoleBean> getRoleList();
	

}
