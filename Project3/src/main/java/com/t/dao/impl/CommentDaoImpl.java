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
import com.t.model.PreferenceBean;

@Repository
public class CommentDaoImpl implements CommentDao{
	
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//抓出該會員在該電影所留的短評 && deleteComment = 0
	@Override
	public CommentBean getComment(Integer memberID) {
		String hql="from CommentBean where memberID = :memberID and commentDelete = 0";
		Session session = factory.getCurrentSession();
		CommentBean cb = session.get(CommentBean.class, memberID);
		return cb;
	}

	//用指定commentID抓留言
	@Override
	public List<CommentBean> memberComment() {
		String hql = "From CommentBean where commentID = :commentID";
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
	public ExpectationBean getAvgGrade(Integer movieID) {
		String hql = "Select AVG(grade) where movieID = :movieID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("movieID", movieID).getResultList();
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

	//列出電影ID
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
		for(int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCommentID();
			System.out.println("留言ID:" + cid);
			String hql1 = "from PreferenceBean where commentID = :id";
			List<PreferenceBean> list1 = session.createQuery(hql1).setParameter("id", cid).getResultList();
			Integer likeNum = 0;
			Integer badNum = 0;
			System.out.println("list1.size():" + list1.size());
			for(int j = 0; j < list1.size(); j++) {
				if(list1.get(j).getGood() == 1) {
					likeNum++;
				}
				if(list1.get(j).getBad() == 1) {
					badNum++;
				}
			}
			System.out.println("目標"+list1.size());
			list.get(i).setBadNum(badNum);
			list.get(i).setLikeNum(likeNum);
		}
		return list;
	}
	
	//用電影ID 查出各個comment
//	@Override
//	public List<CommentBean> getCommentByMovie(Integer movieID){
//		String hql="from CommentBean where movieID = :movieID and commentDelete = 0";
//		Session session=factory.getCurrentSession();
//		List<CommentBean> cmdlist=new ArrayList<>();
//		cmdlist=session.createQuery(hql).setParameter("movieID", movieID).getResultList();
//		
//		String hql0 = "Select commentID from CommentBean where movieID = :movieID";
//		List<Integer> cmdidlist=new ArrayList<>();
//		cmdidlist=session.createQuery(hql0).setParameter("movieID", movieID).getResultList();
//		
//		String hql1 = "Select SUM(good) good,SUM(bad) bad From PreferenceBean group by commentID";
//		List<PreferenceBean> likelist=new ArrayList<>();
//		likelist=session.createQuery(hql1).getResultList();
//		
//		List<CommentBean> cblist = new ArrayList<>();
//		
//		for(Integer i : cmdidlist) {
//			//Integer movieID = 0;
//			String memberID = null;
//			Integer grade = 0;
//			Integer watched = 0;
//			String commentContent = null;
//			String commentTime = null;
//			Integer deleteComment = 0;
//			Integer reportComment = 0;
//			CommentBean cb1 = new CommentBean();
//			for(CommentBean cb : cmdlist) {
//				if(i == cb.getCommentID()) {
//					memberID = cb.getMemberBean().getAccount();
//					grade = cb.getGrade();
//					watched = cb.getWatched();
//					commentContent = cb.getCommentContent();
//					commentTime = cb.getCommentTime();
//					deleteComment = 0;
//					reportComment = 0;
//					
//					cb1.setMemberID(memberID);
//				}
//			}
//		}
//		cblist.add(cb1);
//		return cblist;
//	}

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
