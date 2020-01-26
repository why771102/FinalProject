package com.t.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.p.model.MemberBean;
import com.t.dao.PreferenceDao;
import com.t.model.CommentBean;
import com.t.model.PreferenceBean;

@Repository
public class PreferenceDaoImpl implements PreferenceDao{

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//抓出該會員是否在該留言執行過偏好設定
	@Override
	public boolean checkLikeExist(Integer memberID, Integer commentID) {
		boolean exist = false;
		String hql = "From PreferenceBean Where memberID = :memberID and commentID = :commentID";
		Session session = factory.getCurrentSession();
		try{
			PreferenceBean pb = (PreferenceBean) session.createQuery(hql)
												.setParameter("memberID",memberID)
												.setParameter("commentID",commentID)
												.getSingleResult();
			if(pb != null) {
				exist = true;
			}
		}catch(NoResultException ex) {
			exist = false;
		}catch(NonUniqueResultException ex) {
			exist = false;
		}
		return exist;
	}
	
	//抓出該會員在該留言的讚是否為1
	@Override
	public boolean checkLikeTrue(Integer memberID, Integer commentID) {
		boolean exist = false;
		String hql = "From PreferenceBean Where memberID = :memberID and commentID = :commentID and good = 1";
		Session session = factory.getCurrentSession();
		try{
			PreferenceBean pb = (PreferenceBean) session.createQuery(hql)
												.setParameter("memberID",memberID)
												.setParameter("commentID",commentID)
												.getSingleResult();
			if(pb != null) {
				exist = true;
			}
		}catch(NoResultException ex) {
			exist = false;
		}catch(NonUniqueResultException ex) {
			exist = false;
		}
		return exist;
	}
	
	//抓出該會員在該留言的噓是否為1
	@Override
	public boolean checkDislikeTrue(Integer memberID, Integer commentID) {
		boolean exist = false;
		String hql = "From PreferenceBean Where memberID = :memberID and commentID = :commentID and bad = 1";
		Session session = factory.getCurrentSession();
		try{
			PreferenceBean pb = (PreferenceBean) session.createQuery(hql)
												.setParameter("memberID",memberID)
												.setParameter("commentID",commentID)
												.getSingleResult();
			if(pb != null) {
				exist = true;
			}
		}catch(NoResultException ex) {
			exist = false;
		}catch(NonUniqueResultException ex) {
			exist = false;
		}
		return exist;
	}
	
//	//抓出他填入過的Like
//	@Override
//	public PreferenceBean getLike(Integer good) {
//		Integer Like = null;
//		String hql = "From PreferenceBean Where memberID = :memberID and commentID = :commentID";
//		Session session = factory.getCurrentSession();
//		Like = session.createQuery(hql).setParameter("good",good).getSingleResult();
//		return Like;
//	}
	
	@Override
	public MemberBean getMemberById(int memberID) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		mb = session.get(MemberBean.class,memberID);
		return mb;
	}
	
	@Override
	public CommentBean getCommentById(int commentID) {
		CommentBean cb = null;
		Session session = factory.getCurrentSession();
		cb = session.get(CommentBean.class,commentID);
		return cb;
	}
	
//	@Override
//	public List<MemberBean> getMemberList() {
//		String hql = "FROM MemberBean";
//		Session session = factory.getCurrentSession();
//		List<MemberBean> list = session.createQuery(hql).getResultList();
//		return list;
//	}

	//新建欄位
	@Override
	public void addLike(PreferenceBean pb) {
		Session session = factory.getCurrentSession();
		CommentBean cb = getCommentById(pb.getCommentID());
		MemberBean mb = getMemberById(pb.getMemberID());
		pb.setCommentBean(cb);
		pb.setMemberBean(mb);
		session.save(pb);
	}

	//屏蔽改1
	@Override
	public void fixBlock(Integer memberID, Integer commentID) {
		String hql = "update PreferenceBean set block = 1 where commentID = :commentID and memberID = :memberID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("commentID", commentID)
								.setParameter("memberID", memberID)
								.executeUpdate();
	}

	//good,bad改成1,0
	@Override
	public void addGood(Integer memberID, Integer commentID) {
		String hql = "update PreferenceBean set good = 1, bad = 0 where memberID = :memberID and commentID = :commentID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("commentID", commentID)
								.setParameter("memberID", memberID)
								.executeUpdate();
	}

	//把讚噓取消0,0
	@Override
	public void cancel(Integer memberID, Integer commentID) {
		String hql = "update PreferenceBean set good = 0, bad = 0 where memberID = :memberID and commentID = :commentID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("commentID", commentID)
								.setParameter("memberID", memberID)
								.executeUpdate();
	}

	//good,bad改成0,1
	@Override
	public void addBad(Integer memberID, Integer commentID) {
		String hql = "update PreferenceBean set good = 0, bad = 1 where memberID = :memberID and commentID = :commentID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("commentID", commentID)
								.setParameter("memberID", memberID)
								.executeUpdate();
	}

}
