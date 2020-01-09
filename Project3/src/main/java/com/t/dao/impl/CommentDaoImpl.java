package com.t.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.t.dao.CommentDao;
import com.t.model.CommentBean;
public class CommentDaoImpl implements CommentDao{
	
	SessionFactory factory;

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
	public void createComment(CommentBean cb) {
		String hql = "Insert into CommentBean set movieID = :movieID, memberID = :memberID , watched = :watched, grade = :grade, commentContent  = :commentContent, commentTime = :commentTime, commentDelete = 0 ";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("watched", cb.getWatched())
								.setParameter("grade", cb.getGrade())
								.setParameter("commentContent", cb.getCommentContent())
								.setParameter("commentTime", cb.getCommentTime())
								.setParameter("commentDelete", cb.getCommentDelete()).executeUpdate();
	}

	@Override
	public void deleteComment(CommentBean cb) {
		String hql = "update CommentBean set deleteComment = 1 where commentID = :commentID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).executeUpdate();		
	}

}
