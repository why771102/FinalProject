package com.z.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z.dao.EmpDao;
import com.z.model.EmpBean;
import com.z.model.EmpStatusBean;
import com.z.model.RoleBean;
import com.z.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	
	EmpDao dao;

	@Autowired
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	
	@Transactional
	@Override
	public void saveEmp(EmpBean eb) {
		
		dao.saveEmp(eb);
		
	}
//	@Transactional
//	@Override
//	public void updateEmp(EmpBean eb) {
//		
//		dao.saveEmp(eb);
//
//	}
	@Transactional
	@Override
	public EmpBean isExists(EmpBean eb) {
		
		return dao.isExists(eb);
	}
	
	@Transactional
	@Override
	public List<EmpBean> findAllEmps() {
		return dao.findAllEmps();
	}
	
	@Transactional
	@Override
	public EmpBean getEmp(Integer empId) {
		return dao.getEmp(empId);
	}
	
	@Transactional
	@Override
	public List<RoleBean> getRoleList() {
		return dao.getRoleList();
	}
	
	@Transactional
	@Override
	public List<EmpStatusBean> getEmpStatusList() {
		return dao.getEmpStatusList();
	}
	

}
