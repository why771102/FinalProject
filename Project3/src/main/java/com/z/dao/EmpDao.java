package com.z.dao;

import java.util.List;

import com.z.model.EmpBean;
import com.z.model.RoleBean;

public interface EmpDao {
	
	void saveEmp(EmpBean eb);
	
	void updateEmp(EmpBean eb);
	
	EmpBean isExists(EmpBean eb);
	
	List<EmpBean> findAllEmps();
	
	EmpBean getEmp(Integer empId);

	RoleBean getRoleById(Integer roleId);
	
	List<RoleBean> getRoleList();
	

}
