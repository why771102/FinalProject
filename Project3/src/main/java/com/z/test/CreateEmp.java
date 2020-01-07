package com.z.test;

import com.z.dao.impl.EmpDaoImpl;
import com.z.model.EmpBean;
import com.z.service.impl.EmpServiceImpl;

public class CreateEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EmpServiceImpl esi = new EmpServiceImpl();
		 
		 EmpBean eb = new EmpBean();
		 
		 eb.setMemberName("76");
		 EmpDaoImpl edi = new EmpDaoImpl();
		 esi.setDao(edi);
		 esi.saveEmp(eb);
		
	}

}
