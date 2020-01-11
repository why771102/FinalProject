package com.t.dao;

import com.t.model.ExpectationBean;

public interface ExpectionDao {

	//抓出該電影的期待度(百分比)
	public ExpectationBean getExpection(Integer expection);
	
	//在該movieID的期待+1
	void updateExpect();
		
	//在該movieID的不期待+1
	void updateUnexpect();
}