package com.p.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.p.dao.MemberDao;
import com.p.dao.util.CipherUtils;
import com.p.model.MemberBean;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void register(MemberBean mb) { 
		String s1 = mb.getPassword();//幫密碼進行加密
		String s2 = CipherUtils.getStringMD5(s1);
		mb.setPassword(s2);
		String c1 = mb.getCheckPassword();//幫確認密碼進行加密
		String c2 = CipherUtils.getStringMD5(c1);
		mb.setCheckPassword(c2);
		Session session = factory.getCurrentSession();
		session.save(mb);
	}

	@Override
	public MemberBean queryMember(Integer memberID) {
		Session session = factory.getCurrentSession();
		MemberBean mb = session.get(MemberBean.class, memberID);
		return mb;
//		String hql = "From MemberBean m Where m.account = :account";
//		Session session = factory.getCurrentSession();
//		MemberBean mb = null;
//		try {
//		mb = (MemberBean) session.createQuery(hql)
//								 .setParameter("account", account)
//								 .getSingleResult();
//		}catch(NoResultException ex) {
//			mb = null;
//		}
//		return mb;
	}

	@Override
	public void updateMember(MemberBean mb) { 
		System.out.println(mb.getName());
		String hql = "UPDATE MemberBean SET name = :name, mobile = :mobile , email = :email, address = :address WHERE memberID = :memberID";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("name", mb.getName())
								.setParameter("mobile", mb.getMobile())
								.setParameter("email", mb.getEmail())
								.setParameter("address", mb.getAddress())
								.setParameter("memberID", mb.getMemberID()).executeUpdate();
	}

	// 判斷參數account(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此account不能使用，
	// 否則傳回false，表示此account可使用。
	@Override
	public boolean accountExists(String account) {
		boolean exist = false;
		String hql = "From MemberBean m Where m.account = :account";
		Session session = factory.getCurrentSession();
		try {
			MemberBean mb = (MemberBean) session.createQuery(hql)
												.setParameter("account",account)
												.getSingleResult();
			if(mb != null) {
				exist = true;
			}
		}catch(NoResultException ex) {
			exist = false;
		}catch(NonUniqueResultException ex) {
			exist = false;
		}
		return exist;
	}

	// 判斷參數UID(身分證字號)是否已經被現有客戶使用，如果是，傳回true，表示此UID不能使用，
	// 否則傳回false，表示此UID可使用。
	@Override
	public boolean UIDExists(String UID) {
		boolean exist = false;
		String hql = "From MemberBean m Where m.uID = :uID";
		Session session = factory.getCurrentSession();
		try{
			MemberBean mb = (MemberBean) session.createQuery(hql)
												.setParameter("uID",UID)
												.getSingleResult();
			if(mb != null) {
				exist = true;
			}
		}catch(NoResultException ex) {
			exist = false;
		}catch(NonUniqueResultException ex) {
			exist = false;
		}
		
		return exist;
	}

	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	// 否則傳回 null。
	// 密碼必須要進行加密，才能和資料庫內的進行比對
	@Override
	public MemberBean checkIdPassword(String account, String password) {
		MemberBean mb = null;
		String pwd = CipherUtils.getStringMD5(password);//將傳入的password進行加密
		Session session = factory.getCurrentSession();
		String hql = "From MemberBean m Where m.account = :account and m.password = :password";
		try {
			mb = (MemberBean) session.createQuery(hql)
							.setParameter("account", account)
							.setParameter("password", pwd)
							.getSingleResult();
		} catch (NoResultException ex) {
			mb = null;
		}
		return mb;
	}

	@Override
	public void updateLastLoginTime(String lastLoginTime, Integer memberID) {
		Session session = factory.getCurrentSession();
		String hql = "Update MemberBean set lastLogInTime = :lastLogInTime where memberID = :memberID"; 
		session.createQuery(hql).setParameter("lastLogInTime", lastLoginTime)
								.setParameter("memberID", memberID).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> getMemberList() {
		Session session = factory.getCurrentSession();
		List<MemberBean> list = new ArrayList<>();
		String hql = "FROM MemberBean";
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public MemberBean getEmployeeMember(String uID) {
		MemberBean mb = new MemberBean();
		Session session = factory.getCurrentSession();
		String hql = "From MemberBean Where uID = :uID";
		mb = (MemberBean) session.createQuery(hql).setParameter("uID", uID).getSingleResult();
		return mb;
	}

}
