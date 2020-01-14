package com.z.service;

import java.util.List;

import com.z.model.AnnoBean;
import com.z.model.AnnoStatusBean;

public interface AnnoService {
	
	void addNewAnno(AnnoBean ab);
	
	void launchAnno(Integer annoId);
	
	void takeOff(Integer annoId);
	
//	void updateAnno(AnnoBean ab);
	
	List<AnnoBean> showAnno();

	AnnoBean showOneAnno(Integer annoId);

	List<AnnoStatusBean> getAnnoStatusList();

	List<AnnoBean> showAnnoToMember();
	
	

}
