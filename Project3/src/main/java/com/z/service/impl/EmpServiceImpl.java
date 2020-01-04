package com.z.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z.dao.EmpDao;
import com.z.model.EmpBean;
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
	@Transactional
	@Override
	public void updateEmp(EmpBean eb) {
		
		dao.updateEmp(eb);

	}
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

}