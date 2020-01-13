package com.t.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.dao.CommentDao;
import com.t.model.CommentBean;
import com.t.model.ExpectationBean;
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
		String hql = "Select watched, grade, commentContent, commentTime from CommentBean where commentID = :commitID";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	/**
	 *
	 */
	@Override
	public List<CommentBean> findAllComment(){
		String hql = "Select watched, grade, commentContent, commentTime from CommentBean where movieID = :movieID && commentDelete = 0 && block = 0";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	

	@Override
	public void deleteComment(CommentBean cb) {
		String hql = "update CommentBean set deleteComment = 1 where commentID = :commentID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).executeUpdate();		
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
	public List<CommentBean> getCommentList() {
		// TODO Auto-generated method stub
		return null;
	}

}
