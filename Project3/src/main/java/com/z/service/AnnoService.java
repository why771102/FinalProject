package com.z.service;

import java.util.List;

import com.z.model.AnnoBean;

public interface AnnoService {
	
	void addNewAnno(AnnoBean ab);
	
	void launchAnno(AnnoBean ab);
	
	void takeOff(AnnoBean ab);
	
	void updateAnno(AnnoBean ab);
	
	List<AnnoBean> showAnno();
	
	

}
