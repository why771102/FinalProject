package com.t.dao;

import java.util.List;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.model.ExpectationBean;

public interface ExpectionDao {
	
	//抓出該會員所留的資料
	List<ExpectationBean> getMemberExpectation();

	//抓出所有電影的平均期待度(百分比)
	List<ExpectationBean> getAllExpectation();
	
	//抓出一個電影的平均期待度(百分比)
	List<ExpectationBean> getExpectation();
	
	//輸入新的期待度
	void addExpect(ExpectationBean eb);
	
	//抓memberID
	MemberBean getMemberById(int memberID);
	
	//抓movieID
	MovieBean getMovieById(int movieID);

}
