package com.z.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.z.dao.MemberDao;
import com.z.model.MemberBean;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void saveMember(MemberBean mb) {
		Session session = factory.getCurrentSession();
		session.save(mb);
	}

	@Override
	public void updateMember(MemberBean mb) {
		String hql = "update MemberBean set memberName = :memberName, roleId = :roleId , email = :email, status = :status where memberId = :memberId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("memberName", mb.getMemberName())
								.setParameter("roleId", mb.getRoleId())
								.setParameter("email", mb.getEmail())
								.setParameter("status", mb.getStatus())
								.setParameter("memberId", mb.getMemberId()).executeUpdate();
		
	}

	@Override
	public MemberBean isExists(MemberBean mb) {
		String hql = "form MemberBean where memberId = :memberId";
		Session session = factory.getCurrentSession();
		MemberBean nmb = null;
		nmb = (MemberBean) session.createQuery(hql).getSingleResult();
		return nmb;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> findAllMember() {
		String hql = "from memberBean";
		Session session = factory.getCurrentSession();
		List<MemberBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

}
