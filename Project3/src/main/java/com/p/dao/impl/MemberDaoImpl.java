package com.p.dao.impl;

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
	public void register(MemberBean mb) { //還要研究註冊時間跟最後登入時間要如何寫入
		String s1 = mb.getPassword();//幫密碼進行加密
		String s2 = CipherUtils.getStringMD5(s1);
		mb.setPassword(s2);
		Session session = factory.getCurrentSession();
		session.save(mb);
	}

	@Override
	public MemberBean queryMember(String account) {
		Session session = factory.getCurrentSession();
		MemberBean mb = session.get(MemberBean.class, account);
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
	public void updateMember(MemberBean mb) { //還要看看有無問題
		String hql = "update MemberBean m set m.name = :name, m.mobile = :mobile , m.email = :email, m.address = :address where m.memberId = :memberId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("name", mb.getName())
								.setParameter("mobile", mb.getMobile())
								.setParameter("email", mb.getEmail())
								.setParameter("address", mb.getAddress()).executeUpdate();
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
	// 密碼之後必須要進行加密，才能和資料庫內的進行比對
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

}
