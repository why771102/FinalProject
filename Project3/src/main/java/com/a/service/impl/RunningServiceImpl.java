package com.a.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.dao.RunningDao;
import com.a.model.RunningBean;
import com.a.service.RunningService;

@Service
public class RunningServiceImpl implements RunningService {

	RunningDao dao;
	
	@Autowired
	public void setDao(RunningDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public RunningBean getRunningBeanById(String runningID) {
		
		return dao.getRunningBeanById(runningID);
	}

}
