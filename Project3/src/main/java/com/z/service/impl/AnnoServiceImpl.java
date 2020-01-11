package com.z.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z.dao.AnnoDao;
import com.z.model.AnnoBean;
import com.z.model.AnnoStatusBean;
import com.z.service.AnnoService;

@Service
public class AnnoServiceImpl implements AnnoService {

	AnnoDao dao;
	
	@Transactional
	@Autowired
	public void setDao(AnnoDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public void addNewAnno(AnnoBean ab) {
		dao.addNewAnno(ab);

	}

	@Transactional
	@Override
	public void launchAnno(AnnoBean ab) {
		dao.launchAnno(ab);

	}

	@Transactional
	@Override
	public void takeOff(AnnoBean ab) {
		dao.takeOff(ab);

	}

	@Transactional
	@Override
	public void updateAnno(AnnoBean ab) {
		dao.updateAnno(ab);

	}

	@Transactional
	@Override
	public List<AnnoBean> showAnno() {
		return dao.showAnno();
	}
	
	@Transactional
	@Override
	public AnnoBean showOneAnno(Integer annoId) {
		return dao.showOneAnno(annoId);
	}
	
	@Transactional
	@Override
	public List<AnnoStatusBean> getAnnoStatusList() {
		return dao.getAnnoStatusList();
	}

}
