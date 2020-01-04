package com.z.dao;

import java.util.List;

import com.z.model.AnnoBean;

public interface AnnoDao {
	
	void addNewAnno(AnnoBean ab);
	
	void launchAnno(AnnoBean ab);
	
	void takeOff(AnnoBean ab);
	
	void updateAnno(AnnoBean ab);
	
	List<AnnoBean> showAnno();
	
	

}
