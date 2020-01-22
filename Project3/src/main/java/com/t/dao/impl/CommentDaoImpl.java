package com.t.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.dao.CommentDao;
import com.t.model.CommentBean;
import com.t.model.ExpectationBean;

@Repository
public class CommentDaoImpl implements CommentDao{
	
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public CommentBean getComment(Integer commentId) {
		Session session = factory.getCurrentSession();
		CommentBean cb = session.get(CommentBean.class, commentId);
		if(cb == null) {
//			throw new EmpNotFoundException("", commentId);
		}
		return cb;
	}

	@Override
	public List<CommentBean> memberComment() {
		String hql = "From CommentBean where commentID = :commitID";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public List<CommentBean> findAllComment(){
		String hql = "From CommentBean where commentDelete = 0";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void deleteComment(Integer commentID) {
		String hql = "update CommentBean set commentDelete = 1 where commentID = :commentID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("commentID", commentID).executeUpdate();		
	}
	
	@Override
	public void reportComment(Integer commentID) {
		String hql = "update CommentBean set reportComment = 1 where commentID = :commentID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("commentID", commentID).executeUpdate();
	}

	@Override
	public ExpectationBean getAvgGrade(Integer grade) {
		String hql = "Select grade where movieID = :movieID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).executeUpdate();
		return null;
	}

	@Override
	public void addComment(CommentBean cb) {
		Session session = factory.getCurrentSession();
		MovieBean mvb = getMovieById(cb.getMovieID());
		MemberBean mb = getMemberById(cb.getMemberID());
		cb.setMovieBean(mvb);
		cb.setMemberBean(mb);
		session.save(cb);
	}

	@Override
	public MovieBean getMovieById(int movieID) {
		MovieBean mvb = null;
		Session session = factory.getCurrentSession();
		mvb = session.get(MovieBean.class,movieID);
		return mvb;
	}

	@Override
	public MemberBean getMemberById(int memberID) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		mb = session.get(MemberBean.class,memberID);
		return mb;
	}

	@Override
	public List<MovieBean> getMovieList() {
		String hql = "FROM MovieBean Where movieStatus = 1";
		Session session = factory.getCurrentSession();
		List<MovieBean> list = session.createQuery(hql).getResultList();
		return list;
	}

//	@Override
//	public List<MemberBean> getMemberList() {
//		String hql = "FROM MemberBean";
//		Session session = factory.getCurrentSession();
//		List<MemberBean> list = session.createQuery(hql).getResultList();
//		return list;
//	}

	//列出上映中電影ID
	@Override
	public List<String> getMovies(){
		String hql="Select Distinct movieID from MovieBean Where movieStatus = 1";
		Session session=factory.getCurrentSession();
		List<String> list=new ArrayList<>();
		list=session.createQuery(hql).getResultList();
		return list;
	}
		
	//用電影ID 查出各個comment
	@Override
	public List<CommentBean> getCommentByMovie(Integer movieID){
		String hql="from CommentBean where movieID = :movieID and commentDelete = 0";
		Session session=factory.getCurrentSession();
		List<CommentBean> list=new ArrayList<>();
		list=session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		return list;
	}

	//查詢單筆comment
	@Override
	public CommentBean getTheCommentBean(Integer commentID) {
		Session session = factory.getCurrentSession();
		CommentBean cb = session.get(CommentBean.class, commentID);
		return cb;
	}

	@Override
	public void updateComment(CommentBean cb) {
		String hql="UPDATE CommentBean SET watched = :newwatched, grade = :newgrade, commentContent = :newcommentContent, commentTime = :newcommentTime WHERE commentID = :id";
		Session session=factory.getCurrentSession();
			int n=session.createQuery(hql)	
					.setParameter("newwatched",cb.getWatched())
					.setParameter("newgrade", cb.getGrade())
					.setParameter("newcommentContent", cb.getCommentContent())
					.setParameter("newcommentTime", cb.getCommentTime())
					.setParameter("id", cb.getCommentID())
					.executeUpdate();
	}

	@Override
	public List<CommentBean> findAllReportComment() {
		String hql = "From CommentBean where reportComment = 1 and commentDelete = 0";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

}
