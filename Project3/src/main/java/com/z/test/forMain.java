package com.z.test;

import com.z.dao.impl.EmpDaoImpl;
import com.z.model.EmpBean;
import com.z.service.impl.EmpServiceImpl;

public class forMain {

	public static void main(String[] args) {
		
	EmpDaoImpl edi = new EmpDaoImpl();
		
	EmpServiceImpl esi = new EmpServiceImpl();
	
	esi.setDao(edi);
	
	EmpBean eb = new EmpBean();
	
	eb.setEmail("why771102");
	eb.setMemberName("76");
	eb.setRoleId(1);
	
	
	esi.saveEmp(eb);

	}

}
