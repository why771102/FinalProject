package com.t.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.dao.CommentDao;
import com.t.model.CommentBean;
import com.t.model.ExpectationBean;
import com.t.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService{
	
	CommentDao dao;
	
	@Transactional
	@Autowired
	public void setDao(CommentDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public Double getAvgGrade(Integer movieID) {
		return dao.getAvgGrade(movieID);
	}
	
	@Transactional
	@Override
	public Integer getCommentID(Integer memberID,Integer movieID) {
		return dao.getCommentID(memberID, movieID);
	}
	
	@Transactional
	@Override
	public List<CommentBean> memberComment() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public List<CommentBean> findAllComment() {
		return dao.findAllComment();
	}
	
	@Transactional
	@Override
	public void deleteComment(Integer commentID) {
		dao.deleteComment(commentID);		
	}

	@Transactional
	@Override
	public void addComment(CommentBean cb) {
		dao.addComment(cb);
	}

	@Transactional
	@Override
	public MovieBean getMovieById(int movieID) {
		return dao.getMovieById(movieID);
	}

	@Transactional
	@Override
	public MemberBean getMemberById(int memberID) {
		return dao.getMemberById(memberID);
	}

	@Transactional
	@Override
	public List<MovieBean> getMovieList() {
		return dao.getMovieList();
	}

//	@Transactional
//	@Override
//	public List<MemberBean> getMemberList() {
//		return dao.getMemberList();
//	}
	
	//列出電影ID
	@Transactional
	@Override
	public List<String> getMovies() {
		return dao.getMovies();
	}
	
	//用電影ID查comment(未登入) 照時間排序 早到晚
	@Transactional
	@Override
	public List<CommentBean> getCommentByMovieNoLoginByTime(Integer movieID){
		return dao.getCommentByMovieNoLoginByTime(movieID);
	}
			
	//用電影ID查comment(未登入) 照時間排序 晚到早
	@Transactional
	@Override
	public List<CommentBean> getCommentByMovieNoLoginByTimeDesc(Integer movieID){
		return dao.getCommentByMovieNoLoginByTimeDesc(movieID);
	}
					
	//用電影ID查comment(未登入) 照評分排序 低到高
	@Transactional
	@Override
	public List<CommentBean> getCommentByMovieNoLoginByGrade(Integer movieID){
		return dao.getCommentByMovieNoLoginByGrade(movieID);
	}
				
	//用電影ID查comment(未登入) 照評分排序 高到低
	@Transactional
	@Override
	public List<CommentBean> getCommentByMovieNoLoginByGradeDesc(Integer movieID){
		return dao.getCommentByMovieNoLoginByGradeDesc(movieID);
	}
				
	//用電影ID查comment(登入) 照時間排序 早到晚
	@Transactional
	@Override
	public List<CommentBean> getCommentByMovieOrderByTime(Integer movieID,Integer memberIDBlock){
		return dao.getCommentByMovieOrderByTime(movieID, memberIDBlock);
	}
			
	//用電影ID查comment(登入) 照時間排序 晚到早
	@Transactional
	@Override
	public List<CommentBean> getCommentByMovieOrderByTimeDesc(Integer movieID,Integer memberIDBlock){
		return dao.getCommentByMovieOrderByTimeDesc(movieID, memberIDBlock);
	}
			
	//用電影ID查comment(登入) 照評分排序 低到高
	@Transactional
	@Override
	public List<CommentBean> getCommentByMovieOrderByGrade(Integer movieID,Integer memberIDBlock){
		return dao.getCommentByMovieOrderByGrade(movieID, memberIDBlock);
	}
	
	
	//用電影ID查comment(登入) 照時間排序 高到低
	@Transactional
	@Override
	public List<CommentBean> getCommentByMovieOrderByGradeDesc(Integer movieID,Integer memberIDBlock){
		return dao.getCommentByMovieOrderByGradeDesc(movieID, memberIDBlock);
	}
		

	@Transactional
	@Override
	public CommentBean getTheCommentBean(Integer commentID) {
		return dao.getTheCommentBean(commentID);
	}

	@Transactional
	@Override
	public void updateComment(CommentBean cb) {
		dao.updateComment(cb);
	}

	@Transactional
	@Override
	public void reportComment(Integer commentID) {
		dao.reportComment(commentID);
	}
	
	@Transactional
	@Override
	public List<CommentBean> findAllReportComment() {
		return dao.findAllReportComment();
	}

	@Transactional
	@Override
	public boolean checkCommentExist(Integer memberID,Integer movieID) {
		return dao.checkCommentExist(memberID, movieID);
	}

}
