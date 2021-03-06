package com.t.dao;

import java.util.List;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.model.ExpectationBean;

public interface ExpectionDao {
	
	//查詢並列出電影ID們
	public List<String> getMovies();
	
	//列出未上映電影ID
	public List<String> getStandbyMovies();
	
	//抓出該會員所留的資料
	List<ExpectationBean> getMemberExpectation();

	//抓出所有電影的平均期待度(百分比)
	List<ExpectationBean> getAllExpectation();
	
	//抓出個別電影的平均期待度(百分比)
	public Integer getAvgExpectation(Integer movieID);
	
	//用列出的電影ID查Expectation
	List<ExpectationBean> getExpectationByMovie(Integer movieID);
	
	//抓出該會員是否在該電影留過期待度
	public boolean checkExpectationExist(Integer memberID,Integer movieID);
	
	//輸入新的期待度
	void addExpect(ExpectationBean eb);
	MemberBean getMemberById(int memberID);
	MovieBean getMovieById(int movieID);
//	public List<MemberBean> getMemberList();

}
