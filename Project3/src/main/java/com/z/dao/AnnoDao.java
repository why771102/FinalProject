package com.z.dao;

import java.util.List;

import com.z.model.AnnoBean;
import com.z.model.AnnoStatusBean;

public interface AnnoDao {
	
	void addNewAnno(AnnoBean ab);
	
	void launchAnno(AnnoBean ab);
	
	void takeOff(AnnoBean ab);
	
	void updateAnno(AnnoBean ab);
	
	List<AnnoBean> showAnno();

	AnnoBean showOneAnno(Integer annoId);

	AnnoStatusBean getAnnoStatusById(Integer annoId);

	List<AnnoStatusBean> getAnnoStatusList();

	List<AnnoBean> showAnnoToMember();
	
}