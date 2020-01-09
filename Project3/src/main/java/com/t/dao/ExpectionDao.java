package com.t.dao;

import com.t.model.ExpectationBean;

public interface ExpectionDao {

	//抓出該電影的平均星數(小數點後1位)
	public ExpectationBean getAvgGrade(Integer grade);

	//抓出該電影的期待度(百分比)
	public ExpectationBean getExpection(Integer expection);
	
	//抓出該會員在該電影的哪些評論設定過讚 噓或屏蔽
	

}
