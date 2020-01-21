package com.t.service;

import java.util.List;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.model.ExpectationBean;

public interface ExpectationService {

	//查詢並列出電影ID們
	public List<String> getMovies();
	
	//用列出的電影ID查Expectation
	List<ExpectationBean> getExpectationByMovie(Integer movieID);
	
	//抓出該會員所留的資料
	List<ExpectationBean> getMemberExpectation();

	//抓出所有電影的平均期待度(百分比)
	List<ExpectationBean> getAllExpectation();
	
	//輸入新的期待度
	void addExpect(ExpectationBean eb);
	MemberBean getMemberById(int memberID);
	MovieBean getMovieById(int movieID);
}
