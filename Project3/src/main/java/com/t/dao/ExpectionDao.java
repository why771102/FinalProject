package com.t.dao;

import java.util.List;

import com.a.model.MovieBean;
import com.t.model.ExpectationBean;

public interface ExpectionDao {
	
	//抓出該會員所留的資料
	List<ExpectationBean> getMemberExpectation();

	//抓出所有電影的平均期待度(百分比)
	List<ExpectationBean> getAllExpection();
	
	//輸入新的期待度
	void addExpect(ExpectationBean eb);
	MovieBean getMovieById(int movieID);

}
