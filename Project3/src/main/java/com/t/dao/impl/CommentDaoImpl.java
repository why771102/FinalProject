package com.t.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.dao.CommentDao;
import com.t.model.CommentBean;
import com.t.model.PreferenceBean;

@Repository
public class CommentDaoImpl implements CommentDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//抓出該會員是否在該電影留過言
	@Override
	public boolean checkCommentExist(Integer memberID,Integer movieID) {
		boolean exist = false;
		String hql = "From CommentBean Where memberID = :memberID and movieID = :movieID and commentDelete = 0";
		Session session = factory.getCurrentSession();
		try{
			CommentBean pb = (CommentBean) session.createQuery(hql)
												.setParameter("memberID",memberID)
												.setParameter("movieID", movieID)
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

	// 抓出該會員在該電影所留的短評ID && deleteComment = 0
	@Override
	public Integer getCommentID(Integer memberID,Integer movieID) {
		String hql = "from CommentBean where memberID = :memberID and movieID = :movieID and commentDelete = 0";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("memberID", memberID).setParameter("movieID", movieID).getResultList();
		int id = list.get(0).getCommentID();
		return id;
	}

	// 用指定commentID抓留言
	@Override
	public List<CommentBean> memberComment() {
		String hql = "From CommentBean where commentID = :commentID";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public List<CommentBean> findAllComment() {
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

	//將檢舉的短評reportComment 0改1
	@Override
	public void reportComment(Integer commentID) {
		String hql = "update CommentBean set reportComment = 1 where commentID = :commentID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("commentID", commentID).executeUpdate();
	}
	
	//將審核後沒問題的短評reportComment 1改0
	@Override
	public void cancalReportComment(Integer commentID) {
		String hql = "update CommentBean set reportComment = 0 where commentID = :commentID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("commentID", commentID).executeUpdate();
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
		mvb = session.get(MovieBean.class, movieID);
		return mvb;
	}

	@Override
	public MemberBean getMemberById(int memberID) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		mb = session.get(MemberBean.class, memberID);
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

	// 列出電影ID
	@Override
	public List<String> getMovies() {
		String hql = "from MovieBean Where movieStatus = 1";
		Session session = factory.getCurrentSession();
		List<String> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	
	//印出平均評分
	@Override
	public Double getAvgGrade(Integer movieID) {
		String hql = "from CommentBean where movieID = :movieID and commentDelete = 0";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		Double totalGrade = 0.0;
		Double avgGrade = 0.0;
		Double theGrade = 0.0;
		if(list.size() == 0) {
			avgGrade = 0.0;
		}else {		
			for (int i = 0; i < list.size(); i++) {
				Integer grade = list.get(i).getGrade();
				totalGrade = totalGrade + grade;
			}
			avgGrade = totalGrade/list.size();
		}
		BigDecimal b = new BigDecimal(avgGrade);
		theGrade = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return theGrade;
	}

	//用電影ID查comment(登入) 照時間排序 早到晚
	@Override
	public List<CommentBean> getCommentByMovieOrderByTime(Integer movieID, Integer memberIDBlock) {
		String hql = "from CommentBean where movieID = :movieID and commentDelete = 0 order by commentTime";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		int len = list.size() - 1;
		for (int m = len; m >= 0; m--) {
			String hql2 = "from PreferenceBean where memberID = :memberID and commentID = :id";
			Integer cid = list.get(m).getCommentID();
			List<PreferenceBean> list2 = session.createQuery(hql2).setParameter("memberID", memberIDBlock)
					.setParameter("id", cid).getResultList();
			int len1 = list2.size() - 1;
			for (int k = len1; k >= 0; k--) {
				if (list2.get(k).getGood() == 1) {
					list.get(m).setHaveLike(1);
					list.get(m).setHaveBad(0);
				}if(list2.get(k).getGood() == 0) {
					list.get(m).setHaveLike(0);
					if(list2.get(k).getBad() == 1) {
						list.get(m).setHaveBad(1);
					}if(list2.get(k).getBad() == 0) {
						list.get(m).setHaveBad(0);
					}
				}			
				if (list2.get(k).getBlock() == 1) {
					list.remove(m);
				}				
			}
		}
		for (int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCommentID();
			String hql1 = "from PreferenceBean where commentID = :id";
			List<PreferenceBean> list1 = session.createQuery(hql1).setParameter("id", cid).getResultList();
			Integer likeNum = 0;
			Integer badNum = 0;
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getGood() == 1) {
					likeNum++;
				}
				if (list1.get(j).getBad() == 1) {
					badNum++;
				}
			}
			list.get(i).setBadNum(badNum);
			list.get(i).setLikeNum(likeNum);
		}
		return list;
	}
	
	//用電影ID查comment(登入) 照時間排序 晚到早
	@Override
	public List<CommentBean> getCommentByMovieOrderByTimeDesc(Integer movieID, Integer memberIDBlock) {
		String hql = "from CommentBean where movieID = :movieID and commentDelete = 0 order by commentTime desc";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		int len = list.size() - 1;
		for (int m = len; m >= 0; m--) {
			String hql2 = "from PreferenceBean where memberID = :memberID and commentID = :id";
			Integer cid = list.get(m).getCommentID();
			List<PreferenceBean> list2 = session.createQuery(hql2).setParameter("memberID", memberIDBlock)
					.setParameter("id", cid).getResultList();
			int len1 = list2.size() - 1;
			for (int k = len1; k >= 0; k--) {
				if (list2.get(k).getBlock() == 1) {
					list.remove(m);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCommentID();
			String hql1 = "from PreferenceBean where commentID = :id";
			List<PreferenceBean> list1 = session.createQuery(hql1).setParameter("id", cid).getResultList();
			Integer likeNum = 0;
			Integer badNum = 0;
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getGood() == 1) {
					likeNum++;
				}
				if (list1.get(j).getBad() == 1) {
					badNum++;
				}
			}
			list.get(i).setBadNum(badNum);
			list.get(i).setLikeNum(likeNum);
		}
		return list;
	}
	
	//用電影ID查comment(登入) 照評分排序 低到高
	@Override
	public List<CommentBean> getCommentByMovieOrderByGrade(Integer movieID, Integer memberIDBlock) {
		String hql = "from CommentBean where movieID = :movieID and commentDelete = 0 order by grade";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		int len = list.size() - 1;
		for (int m = len; m >= 0; m--) {
			String hql2 = "from PreferenceBean where memberID = :memberID and commentID = :id";
			Integer cid = list.get(m).getCommentID();
			List<PreferenceBean> list2 = session.createQuery(hql2).setParameter("memberID", memberIDBlock)
					.setParameter("id", cid).getResultList();
			int len1 = list2.size() - 1;
			for (int k = len1; k >= 0; k--) {
				if (list2.get(k).getBlock() == 1) {
					list.remove(m);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCommentID();
			String hql1 = "from PreferenceBean where commentID = :id";
			List<PreferenceBean> list1 = session.createQuery(hql1).setParameter("id", cid).getResultList();
			Integer likeNum = 0;
			Integer badNum = 0;
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getGood() == 1) {
					likeNum++;
				}
				if (list1.get(j).getBad() == 1) {
					badNum++;
				}
			}
			list.get(i).setBadNum(badNum);
			list.get(i).setLikeNum(likeNum);
		}
		return list;
	}
	
	//用電影ID查comment(登入) 照評分排序 高到低
	@Override
	public List<CommentBean> getCommentByMovieOrderByGradeDesc(Integer movieID, Integer memberIDBlock) {
		String hql = "from CommentBean where movieID = :movieID and commentDelete = 0 order by grade desc";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		int len = list.size() - 1;
		for (int m = len; m >= 0; m--) {
			String hql2 = "from PreferenceBean where memberID = :memberID and commentID = :id";
			Integer cid = list.get(m).getCommentID();
			List<PreferenceBean> list2 = session.createQuery(hql2).setParameter("memberID", memberIDBlock)
					.setParameter("id", cid).getResultList();
			int len1 = list2.size() - 1;
			for (int k = len1; k >= 0; k--) {
				if (list2.get(k).getGood() == 1) {
					list.get(m).setHaveLike(1);
					list.get(m).setHaveBad(0);
				}if(list2.get(k).getGood() == 0) {
					list.get(m).setHaveLike(0);
					if(list2.get(k).getBad() == 1) {
						list.get(m).setHaveBad(1);
					}if(list2.get(k).getBad() == 0) {
						list.get(m).setHaveBad(0);
					}
				}
				if (list2.get(k).getBlock() == 1) {
					list.remove(m);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCommentID();
			String hql1 = "from PreferenceBean where commentID = :id";
			List<PreferenceBean> list1 = session.createQuery(hql1).setParameter("id", cid).getResultList();
			Integer likeNum = 0;
			Integer badNum = 0;
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getGood() == 1) {
					likeNum++;
				}
				if (list1.get(j).getBad() == 1) {
					badNum++;
				}
			}
			list.get(i).setBadNum(badNum);
			list.get(i).setLikeNum(likeNum);
		}
		return list;
	}
	
	//用電影ID查comment(未登入) 照時間排序 早到晚
	@Override
	public List<CommentBean> getCommentByMovieNoLoginByTime(Integer movieID) {
		String hql = "from CommentBean where movieID = :movieID and commentDelete = 0 order by commentTime";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		for (int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCommentID();
			String hql1 = "from PreferenceBean where commentID = :id";
			List<PreferenceBean> list1 = session.createQuery(hql1).setParameter("id", cid).getResultList();
			Integer likeNum = 0;
			Integer badNum = 0;
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getGood() == 1) {
					likeNum++;
				}
				if (list1.get(j).getBad() == 1) {
					badNum++;
				}
			}
			list.get(i).setBadNum(badNum);
			list.get(i).setLikeNum(likeNum);
		}
		return list;
	}
	
	//用電影ID查comment(未登入) 照時間排序 晚到早
	@Override
	public List<CommentBean> getCommentByMovieNoLoginByTimeDesc(Integer movieID) {
		String hql = "from CommentBean where movieID = :movieID and commentDelete = 0 order by commentTime desc";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		for (int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCommentID();
			String hql1 = "from PreferenceBean where commentID = :id";
			List<PreferenceBean> list1 = session.createQuery(hql1).setParameter("id", cid).getResultList();
			Integer likeNum = 0;
			Integer badNum = 0;
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getGood() == 1) {
					likeNum++;
				}
				if (list1.get(j).getBad() == 1) {
					badNum++;
				}
			}
			list.get(i).setBadNum(badNum);
			list.get(i).setLikeNum(likeNum);
		}
		return list;
	}
	
	//用電影ID查comment(未登入) 照評分排序 早到晚
	@Override
	public List<CommentBean> getCommentByMovieNoLoginByGrade(Integer movieID) {
		String hql = "from CommentBean where movieID = :movieID and commentDelete = 0 order by grade";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		for (int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCommentID();
			String hql1 = "from PreferenceBean where commentID = :id";
			List<PreferenceBean> list1 = session.createQuery(hql1).setParameter("id", cid).getResultList();
			Integer likeNum = 0;
			Integer badNum = 0;
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getGood() == 1) {
					likeNum++;
				}
				if (list1.get(j).getBad() == 1) {
					badNum++;
				}
			}
			list.get(i).setBadNum(badNum);
			list.get(i).setLikeNum(likeNum);
		}
		return list;
	}
	
	//用電影ID查comment(未登入) 照評分排序 晚到早
	@Override
	public List<CommentBean> getCommentByMovieNoLoginByGradeDesc(Integer movieID) {
		String hql = "from CommentBean where movieID = :movieID and commentDelete = 0 order by grade desc";
		Session session = factory.getCurrentSession();
		List<CommentBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		for (int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCommentID();
			String hql1 = "from PreferenceBean where commentID = :id";
			List<PreferenceBean> list1 = session.createQuery(hql1).setParameter("id", cid).getResultList();
			Integer likeNum = 0;
			Integer badNum = 0;
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).getGood() == 1) {
					likeNum++;
				}
				if (list1.get(j).getBad() == 1) {
					badNum++;
				}
			}
			list.get(i).setBadNum(badNum);
			list.get(i).setLikeNum(likeNum);
		}
		return list;
	}

	// 用電影ID 查出各個comment
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

	// 查詢單筆comment
	@Override
	public CommentBean getTheCommentBean(Integer commentID) {
		Session session = factory.getCurrentSession();
		CommentBean cb = session.get(CommentBean.class, commentID);
		return cb;
	}

	@Override
	public void updateComment(CommentBean cb) {
		String hql = "UPDATE CommentBean SET watched = :newwatched, grade = :newgrade, commentContent = :newcommentContent WHERE commentID = :id";
		Session session = factory.getCurrentSession();
		int n = session.createQuery(hql).setParameter("newwatched", cb.getWatched())
				.setParameter("newgrade", cb.getGrade()).setParameter("newcommentContent", cb.getCommentContent())
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