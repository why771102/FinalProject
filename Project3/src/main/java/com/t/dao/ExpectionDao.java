package com.t.dao;

import com.t.model.ExpectationBean;

public interface ExpectionDao {

	//抓出該電影的期待度(百分比)
	public ExpectationBean getExpection(Integer expection);
	
}
